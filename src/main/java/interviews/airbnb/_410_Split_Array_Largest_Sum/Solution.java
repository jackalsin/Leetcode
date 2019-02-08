package interviews.airbnb._410_Split_Array_Largest_Sum;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/7/2019.
 */
public final class Solution {
  public int splitArray(int[] nums, int m) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int n = nums.length;
    final int[] preSum = new int[n + 1];
    for (int i = 0; i < nums.length; i++) {
      preSum[i + 1] = preSum[i] + nums[i];

    }

    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 2; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    System.arraycopy(preSum, 0, dp[1], 0, n + 1);
    // 1, 3, 5
    // 0, 1, 4, 9,

    // 0: 0, 0, 0, 0
    // 1: 0, 1, 4, 9
    // 2: 0, 0,


    for (int i = 1; i < m; i++) {
      for (int j = i; j < n; j++) {
        for (int k = 1; j - k >= 0; k++) {
          dp[i + 1][j + 1] = Math.min(Math.max(dp[i][j - k + 1], (preSum[j + 1] - preSum[j - (k - 1)])), dp[i + 1][j + 1]);
        }
      }
    }

//    display(dp);

    return dp[m][n];
  }
}
