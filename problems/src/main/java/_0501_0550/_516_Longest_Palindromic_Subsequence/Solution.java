package _0501_0550._516_Longest_Palindromic_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public class Solution {
  public int longestPalindromeSubseq(String s) {
    final int[][] dp = new int[s.length()][s.length()];
    for (int i = s.length() - 1; i >= 0; --i) {
      dp[i][i] = 1;
      for (int j = i + 1; j < s.length(); ++j) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][s.length() - 1];
  }

}
