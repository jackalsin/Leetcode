package interviews.airbnb._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class Solution {
  private static final int ROB = 0, NOT_ROB = 1;

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[][] dp = new int[2][nums.length + 1];
    dp[ROB][1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[ROB][i + 1] = Math.max(dp[ROB][i - 1], dp[NOT_ROB][i]) + nums[i];
      dp[NOT_ROB][i + 1] = Math.max(dp[NOT_ROB][i], dp[ROB][i]);
    }
    return Math.max(dp[ROB][nums.length], dp[NOT_ROB][nums.length]);
  }
}
