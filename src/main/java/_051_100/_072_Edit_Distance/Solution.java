package _051_100._072_Edit_Distance;

/**
 * @author jacka
 * @version 1.0 on 4/29/2017.
 */
public class Solution {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word2.length() + 1][word1.length() + 1];
    for (int i = 1; i < word1.length() + 1; i++) {
      dp[0][i] = i;
    }
    for (int j = 1; j < word2.length() + 1; j++) {
      for (int i = 0; i < word1.length() + 1; i++) {
        if (i == 0) {
          dp[j][i] = j;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[j][i] = dp[j - 1][i - 1];
        } else {
          dp[j][i] = Math.min(dp[j][i - 1] + 1, Math.min(dp[j - 1][i - 1] + 1, dp[j - 1][i] + 1));
        }
      }
    }
    return dp[word2.length()][word1.length()];
  }
}
