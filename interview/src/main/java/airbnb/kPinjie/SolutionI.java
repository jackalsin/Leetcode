package airbnb.kPinjie;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  /**
   * [i, j] 选择k个，最大的那个
   */
  private final Map<List<Integer>, String> cache = new HashMap<>();
  private int[][] max;

  @Override
  public String getBiggestNumWithKSelection(int[] nums, int k) {
    if (nums == null) {
      return "";
    }
    max = getMax(nums);

    return dfs(nums, 0, nums.length - 1, k);
  }

  private int[][] getMax(final int[] nums) {
    final int N = nums.length;
    final int[][] res = new int[N][N];
    for (int i = N - 1; i >= 0; i--) {
      res[i][i] = nums[i];
      for (int j = i + 1; j < N; j++) {
        res[i][j] = Math.max(res[i][j - 1], res[i + 1][j]);
      }
    }
    return res;
  }

  private String dfs(final int[] nums, final int start, final int end, final int k) {
    final List<Integer> key = List.of(start, end, k);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    if (k == 1) {
      return String.valueOf(max[start][end]);
    }
    assert end >= start;
    assert k >= 0;
    if (end - start + 1 <= k) {
      final String res = fullConnect(nums, start, end);
      cache.put(key, res);
      return res;
    }
    BigInteger best = BigInteger.ZERO;
    for (int i = start + k - 2; i < end; i++) {
      final String curMax = dfs(nums, start, i, k - 1);
      final int maxTail = max[i + 1][end];
      BigInteger cur = new BigInteger(curMax + maxTail);
      if (cur.compareTo(best) > 0) {
        best = cur;
      }
    }
    final String bestResult = best.toString();
    cache.put(key, bestResult);
    return bestResult;
  }

  private static String fullConnect(final int[] nums, final int i, final int j) {
    final StringBuilder sb = new StringBuilder();
    for (int k = i; k <= j; k++) {
      sb.append(nums[k]);
    }
    return sb.toString();
  }
}
