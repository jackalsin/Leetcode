package interviews.uber.blacklistSampling;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SolutionTest {
  private Solution solution;

  private static final double BIAS = 1E-3;

  @Test
  void testRegularCase() {
    final int[] blackList = {1, 3, 5, 9};
    solution = new Solution(blackList);
    final Set<Integer> blackSet = Arrays.stream(blackList).boxed().collect(Collectors.toSet());
    final Map<Integer, Double> counts = new HashMap<>();
    final List<Integer> candidates = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    final int N = 1_000_000;
    for (int i = 0; i < N; i++) {
      final int cand = solution.getRandom(candidates);
      if (blackSet.contains(cand)) {
        fail("Failed candidate = " + cand);
      }
      counts.put(cand, counts.getOrDefault(cand, 0d) + 1);
    }

    counts.entrySet().forEach(x -> x.setValue(x.getValue() / N));
    counts.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
    counts.forEach((key, value) -> assertEquals(1d / 8, value, BIAS, "Checking key = " + key));

  }
}