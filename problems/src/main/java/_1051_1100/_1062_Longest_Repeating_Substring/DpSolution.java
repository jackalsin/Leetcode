package _1051_1100._1062_Longest_Repeating_Substring;

/**
 * @author zhixi
 * @version 1.0 on 3/7/2021
 */
public final class DpSolution implements Solution {
  /**
   * TODO:
   * Time Complexity: O(N^2)
   */
  @Override
  public int longestRepeatingSubstring(String s) {
    final int n = s.length();
    /*
    dp[i + 1][j + 1] denotes max length it have ending at i and ending at j
    */
    final int[][] dp = new int[n + 1][n + 1];

    int res = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
          res = Math.max(res, dp[i + 1][j + 1]);
        }
      }
    }
    return res;
  }
}
