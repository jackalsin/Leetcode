package google._072_Edit_Distance;

/**
 * @author jacka
 * @version 1.0 on 1/23/2018.
 */
public class Solution {
  public int minDistance(String word1, String word2) {
    final int[][] dp = new int[word2.length() + 1][word1.length() + 1];
    for (int j = 0; j <= word1.length(); j++) {
      dp[0][j] = j;
    }

    for (int i = 0; i < word2.length(); i++) {
      dp[i + 1][0] = i + 1;
      for (int j = 0; j < word1.length(); j++) {
        if (word1.charAt(j) == word2.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1));
        }
      }
    }
    return dp[word2.length()][word1.length()];
  }
}
