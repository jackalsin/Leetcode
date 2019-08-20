package _1101_1150._1117_Building_H2O;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._1117_Building_H2O.ReleaseHydrogen;
import utils._1117_Building_H2O.ReleaseOxygen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
class H2OTest {
  private static final ExecutorService pool =
      Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
  private static final int N = 99;
  private static final Set<String> LEGAL = Set.of(
      "HHO",
      "OHH",
      "HOH"
  );

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(H2O solutionProvider) throws InterruptedException, ExecutionException {
    final StringBuffer sb = new StringBuffer();
    final List<Callable<Object>> callables = new ArrayList<>();
    final ReleaseHydrogen releaseHydrogen = new ReleaseHydrogen(sb);
    final ReleaseOxygen releaseOxygen = new ReleaseOxygen(sb);
    for (int i = 0; i < N; ++i) {
      if (i % 3 != 0) {
        callables.add(Executors.callable(() -> {
          try {
            solutionProvider.hydrogen(releaseHydrogen);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }));
      } else {
        callables.add(Executors.callable(() -> {
          try {
            solutionProvider.oxygen(releaseOxygen);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }));
      }
    }
    System.out.println("Start Execution: " + this.getClass().getName());
    final List<Future<Object>> result = pool.invokeAll(callables);
    for (Future<Object> objectFuture : result) {
      objectFuture.get();
    }
    System.out.println("End Execution: " + this.getClass().getName());

    for (int i = 0; i < N; i += 3) {
      final String s = sb.substring(i, i + 3);
      assertTrue(LEGAL.contains(s));
    }
  }

  @AfterAll
  static void afterAll() {
    pool.shutdown(); // Disable new tasks from being submitted
    try {
      // Wait a while for existing tasks to terminate
      if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
        pool.shutdownNow(); // Cancel currently executing tasks
        // Wait a while for tasks to respond to being cancelled
        if (!pool.awaitTermination(60, TimeUnit.SECONDS))
          System.err.println("Pool did not terminate");
      }
    } catch (InterruptedException ie) {
      // (Re-)Cancel if current thread also interrupted
      pool.shutdownNow();
      // Preserve interrupt status
      Thread.currentThread().interrupt();
    }
  }

  static Stream<H2O> solutionProvider() {
    return Stream.of(
        new LockH2O(),
        new SemaphoreH2O()
    );
  }

}