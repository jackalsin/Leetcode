package linkedin.mianjing.hashTable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {

  private HashTable<Integer> table;
  private ExecutorService executor;

  @BeforeEach
  void setup() {
    executor = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors());
    table = new HashTable<>();
  }

  @Test
  void testCase1() throws InterruptedException, ExecutionException {
    final int[] input = {1, 2, 3, 4, 5, 10, 11, 12, 13, 1, 2, 3};
    final List<Callable<Boolean>> taskContainsWithoutAdd = new ArrayList<>();
    for (final int i : input) {
      taskContainsWithoutAdd.add(() -> table.contains(i));
    }
    // make sure no one
    final List<Future<Boolean>> resultOfContainsNoAdd = executor.invokeAll(taskContainsWithoutAdd);
    for (Future<Boolean> f : resultOfContainsNoAdd) {
      assertFalse(f.get());
    }

    final List<Callable<Boolean>> taskAdd = new ArrayList<>();
    for (final int i : input) {
      taskAdd.add(() -> table.add(i));
    }
    final Map<Boolean, Integer> expected = Map.of(true, 9, false, 3);
    final Map<Boolean, Integer> count = new HashMap<>();
    final List<Future<Boolean>> resultOfAdd = executor.invokeAll(taskAdd);
    for (Future<Boolean> f : resultOfAdd) {
      final boolean res = f.get();
      count.put(res, count.getOrDefault(res, 0) + 1);
    }

    assertEquals(expected, count);

  }

  @AfterEach
  void teardown() {
    executor.shutdown(); // Disable new tasks from being submitted
    try {
      // Wait a while for existing tasks to terminate
      if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
        executor.shutdownNow(); // Cancel currently executing tasks
        // Wait a while for tasks to respond to being cancelled
        if (!executor.awaitTermination(60, TimeUnit.SECONDS))
          System.err.println("Pool did not terminate");
      }
    } catch (InterruptedException ie) {
      // (Re-)Cancel if current thread also interrupted
      executor.shutdownNow();
      // Preserve interrupt status
      Thread.currentThread().interrupt();
    }
  }
}