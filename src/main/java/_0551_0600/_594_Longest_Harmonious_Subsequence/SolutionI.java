package _0551_0600._594_Longest_Harmonious_Subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class SolutionI implements Solution {
  private final Map<Long, Integer> minToCount = new HashMap<>();

  public int findLHS(int[] nums) {
    int max = 0;
    for (final long n : nums) {
      minToCount.put(n, minToCount.getOrDefault(n, 0) + 1);
    }
    for (final long n : nums) {
      if (minToCount.containsKey(n - 1)) {
        max = Math.max(max, minToCount.get(n - 1) + minToCount.get(n));
      }
    }
    return max;
  }
}
