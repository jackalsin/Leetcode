package interviews.airbnb._377_Combination_Sum_IV;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
public final class BottomUpSolution implements Solution {
  public int combinationSum4(int[] nums, int target) {
    final int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int nu : nums) {
        if (i >= nu) {
          dp[i] += dp[i - nu];
        }
      }
    }
    return dp[target];
  }
}
