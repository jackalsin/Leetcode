package dropbox.tokenBucket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * @author jacka
 * @version 1.0 on 5/31/2021
 */
class TokenBucketITest {
  private ExecutorService executor;

  @BeforeEach
  void setup() {
    executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<TokenBucket> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException, InterruptedException, ExecutionException {
    final TokenBucket tokenBucket = solutionClass.getConstructor(int.class, int.class).newInstance(3, 1);
    final List<ConsumeTask> tasks = List.of(
        new ConsumeTask(tokenBucket, 1),
        new ConsumeTask(tokenBucket, 1),
        new ConsumeTask(tokenBucket, 1),
        new ConsumeTask(tokenBucket, 1),
        new ConsumeTask(tokenBucket, 1)
    );
    System.out.println("Start token bucket service.");
    executor.submit(tokenBucket);
    System.out.println("Get task: " + Calendar.getInstance().getTime());

    final List<Future<List<Integer>>> actual = executor.invokeAll(tasks);
    for (final Future<List<Integer>> f : actual) {
      assert f.isDone();
      System.out.println(f.get());
    }
  }

  private static class ConsumeTask implements Callable<List<Integer>> {
    private final TokenBucket bucket;
    private final int token;

    private ConsumeTask(TokenBucket bucket, final int token) {
      this.bucket = bucket;
      this.token = token;
    }

    @Override
    public List<Integer> call() throws Exception {
      return bucket.get(token);
    }
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        TokenBucketI.class
    );
  }
}