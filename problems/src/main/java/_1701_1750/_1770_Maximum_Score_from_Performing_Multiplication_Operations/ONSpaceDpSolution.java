package _1701_1750._1770_Maximum_Score_from_Performing_Multiplication_Operations;

/**
 * @author jacka
 * @version 1.0 on 4/25/2021
 */
public final class ONSpaceDpSolution implements Solution {
  public int maximumScore(int[] nums, int[] multipliers) {
    final int m = multipliers.length, n = nums.length;
    int[] dp = new int[n];
    for (int l = 1; l <= m; ++l) {
      final int[] next = new int[n];
      final int mul = multipliers[multipliers.length - l];
      for (int left = 0, right = left + (n - m) + (l - 1); right < n; ++left, ++right) {
        if (l == 1) {
          next[left] = Math.max(nums[left] * mul, mul * nums[right]);
        } else {
          final int res = Math.max(nums[left] * mul + dp[left + 1],
              nums[right] * mul + dp[left]);
          next[left] = res;
        }
      } // end of for left, right
      dp = next;
    }
    return dp[0];
  }

}
