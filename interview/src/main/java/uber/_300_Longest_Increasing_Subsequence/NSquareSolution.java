package uber._300_Longest_Increasing_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 3/16/2018.
 */
public class NSquareSolution implements Solution {
  public int lengthOfLIS(int[] nums) {
    final int[] dp = new int[nums.length];
    int best = 1;
    dp[0] = 1;
    for (int j = 1; j < nums.length; j++) {
      dp[j] = 1;
      for (int i = 0; i < j; i++) {
        if (nums[i] < nums[j]) {
          dp[j] = Math.max(dp[j], dp[i] + 1);
        }
      }
      best = Math.max(best, dp[j]);
    }
    return best;
  }
}
