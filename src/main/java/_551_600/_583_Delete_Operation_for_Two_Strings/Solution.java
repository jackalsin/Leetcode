package _551_600._583_Delete_Operation_for_Two_Strings;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
 */
public class Solution {
  public int minDistance(String word1, String word2) {
    final int m = word1.length(), n = word2.length();
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j]);
        }
      }
    }
    int longestCommonLength = dp[m][n];
    return word1.length() + word2.length() - 2 * longestCommonLength;
  }
}
