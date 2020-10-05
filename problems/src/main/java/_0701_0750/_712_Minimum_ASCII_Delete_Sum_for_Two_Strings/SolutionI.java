package _0701_0750._712_Minimum_ASCII_Delete_Sum_for_Two_Strings;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minimumDeleteSum(String s1, String s2) {
    final int m = s1.length(), n = s2.length();
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (s1.charAt(i) == s2.charAt(j)) {
          dp[i + 1][j + 1] = s1.charAt(i);
        }
        dp[i + 1][j + 1] += dp[i][j];
        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]);
        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
      }
    }
    return getSum(s1) - dp[m][n] + getSum(s2) - dp[m][n];
  }

  private static int getSum(final String s) {
    int sum = 0;
    for (char chr : s.toCharArray()) {
      sum += chr;
    }
    return sum;
  }
}
