package _1701_1750._1770_Maximum_Score_from_Performing_Multiplication_Operations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/25/2021
 */
public final class SlowSolution implements Solution {
  private static final int TIMES = (int) 1E5;

  public int maximumScore(int[] nums, int[] multipliers) {
    final Map<Integer, Integer> cache = new HashMap<>();
    final int n = nums.length, m = multipliers.length;
    return maximumScore(cache, nums, multipliers, 0, n - 1, 0);
  }

  private int maximumScore(final Map<Integer, Integer> cache, final int[] nums, final int[] multipliers,
                           final int left, final int right, final int m) {
    if (m == multipliers.length) {
      return 0;
    }
    final int key = (left * TIMES) + right;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    final int removeLeft = maximumScore(cache, nums, multipliers, left + 1, right, m + 1) + nums[left] * multipliers[m],
        removeRight = maximumScore(cache, nums, multipliers, left, right - 1, m + 1) + nums[right] * multipliers[m];
    final int res = Math.max(removeLeft, removeRight);
    cache.put(key, res);
    return res;
  }

}
