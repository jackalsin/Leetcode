package _0401_0450._410_Split_Array_Largest_Sum;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public final class DpSolutionI implements Solution {
  public int splitArray(int[] nums, int m) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int n = nums.length;
    final int[] preSum = new int[nums.length + 1];
    for (int i = 0; i < n; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    } // sum [j] - sum[i] = sum (i, j]

    // dp[i][j] denotes
    final int[][] dp = new int[n + 1][m + 1];

    for (final int[] d : dp) {
      Arrays.fill(d, Integer.MAX_VALUE);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        for (int k = 0; k < i; k++) {
          // around k ~ n
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], preSum[i] - preSum[k]));
        }
      }
    }
//    TwoDimensionArray.display2DimensionArray(dp);
    return dp[n][m];
  }
}
