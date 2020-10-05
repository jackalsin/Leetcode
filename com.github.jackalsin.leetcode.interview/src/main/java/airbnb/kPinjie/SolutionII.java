package airbnb.kPinjie;

import java.math.BigInteger;

public final class SolutionII implements Solution {
  @Override
  public String getBiggestNumWithKSelection(int[] nums, int k) {
    if (nums == null) {
      throw new NullPointerException();
    }

    // dp[i][j] indicates the longest string choosing i from [0, j]
    final StringBuilder[][] dp = new StringBuilder[k + 1][nums.length + 1];
    for (int col = 0; col <= nums.length; col++) {
      dp[0][col] = new StringBuilder();
    }

    for (int i = 1; i <= k; i++) {
      dp[i][i - 1] = new StringBuilder(dp[i - 1][i - 1]).append(nums[i - 1]);
      for (int j = i; j <= nums.length; j++) {
        final StringBuilder str1 = dp[i][j - 1],
            str2 = new StringBuilder(dp[i - 1][j - 1]).append(nums[j - 1]);
        dp[i][j] = (compare(str1.toString(), str2.toString()) < 0) ? str2 : str1;
      }
    }

    return dp[k][nums.length].toString();
  }

  private static int compare(final String i, final String j) {
    return new BigInteger(i).compareTo(new BigInteger(j));
  }
}
