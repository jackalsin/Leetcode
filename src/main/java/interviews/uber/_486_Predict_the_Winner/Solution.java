package interviews.uber._486_Predict_the_Winner;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  // TODO :
  public boolean PredictTheWinner(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    final int n = nums.length;
    /* max score the current player can get */
    final int[][] dp = new int[n][n];
    final int[] preSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    }

    for (int i = 0; i < n; i++) {
      for (int row = 0, col = i; col < n; row++, col++) {
        if (i == 0) {
          dp[row][col] = nums[col];
        } else {
          dp[row][col] = Math.max(nums[col] + preSum[col] - preSum[row] - dp[row][col - 1],
              nums[row] + preSum[col + 1] - preSum[row + 1] - dp[row + 1][col]);
        }
      }
    }

    return dp[0][n - 1] * 2 > preSum[n];
  }
}
