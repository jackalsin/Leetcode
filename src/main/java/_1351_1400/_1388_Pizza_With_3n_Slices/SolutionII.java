package _1351_1400._1388_Pizza_With_3n_Slices;

import java.util.HashMap;
import java.util.Map;

public final class SolutionII implements Solution {
  private static final String SEP = "$";
  private final Map<String, Integer> cache = new HashMap<>();

  /**
   * https://leetcode.com/problems/pizza-with-3n-slices/discuss/546474/Python-Robber-n3-Houses-in-Cycle
   * <p>
   * [8, 9, 9, 6, 1, 1] found 2 number in this 6 number which are not neighbored
   */
  public int maxSizeSlices(int[] slices) {
    final int n = slices.length, remain = slices.length / 3;
    final int res = Math.max(
        slices[n - 1] + maxSizeSlices(slices, 1, n - 3, remain - 1),
        maxSizeSlices(slices, 0, n - 2, remain));
    return res;
  }

  public int maxSizeSlices(final int[] slices, final int i, final int j, final int remain) {
    final String key = i + SEP + j + SEP + remain;
    if (remain == 0) {
      return 0;
    }
    if (remain == 1) {
      int max = 0;
      for (int k = i; k <= j; ++k) {
        max = Math.max(max, slices[k]);
      }
      return max;
    }
    if (j - i + 1 < 2 * remain - 1) {
      return Integer.MIN_VALUE;
    }
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    final int useJ = slices[j] + maxSizeSlices(slices, i, j - 2, remain - 1),
        noUseJ = maxSizeSlices(slices, i, j - 1, remain),
        res = Math.max(useJ, noUseJ);
    cache.put(key, res);
    return res;
  }
}
