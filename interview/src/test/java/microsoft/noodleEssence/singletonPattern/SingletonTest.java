package microsoft.noodleEssence.singletonPattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonTest {
  private final ExecutorService executor =
      Executors.newFixedThreadPool(
          Runtime.getRuntime().availableProcessors() * 2
      );

  @Test
  void testOnlineCase1() {
    final List<Future<Long>> result = new ArrayList<>();
    final int times = 20_000;
    for (int i = 0; i < times; i++) {
      result.add(executor.submit(() -> {
        final SingletonSynchronizedMethod solution = SingletonSynchronizedMethod.getInstance();
        return solution.getId();
      }));
    }
    for (int i = 0; i < times; i++) {
      try {
        assertEquals(Long.valueOf(0), result.get(i).get());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
  }

}