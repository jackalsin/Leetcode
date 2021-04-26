package _1701_1750._1770_Maximum_Score_from_Performing_Multiplication_Operations;

/**
 * @author jacka
 * @version 1.0 on 4/25/2021
 */
public final class DpSolution implements Solution {
  public int maximumScore(int[] nums, int[] multipliers) {
    final int m = multipliers.length, n = nums.length;
    final Integer[][] dp = new Integer[m][m];
    return maximumScore(dp, nums, multipliers, 0, n - 1, 0);
  }

  private static int maximumScore(final Integer[][] dp, final int[] nums, final int[] multipliers,
                                  final int left, final int right, final int m) {
    if (m == multipliers.length) {
      return 0;
    }
    final int i = left, j = multipliers.length - (nums.length - right);
    if (dp[i][j] != null) {
      return dp[i][j];
    }
    final int leftRes = maximumScore(dp, nums, multipliers, left + 1, right, m + 1) + nums[left] * multipliers[m],
        rightRes = maximumScore(dp, nums, multipliers, left, right - 1, m + 1) + nums[right] * multipliers[m],
        res = Math.max(leftRes, rightRes);
    dp[i][j] = res;
    return res;
  }
}
