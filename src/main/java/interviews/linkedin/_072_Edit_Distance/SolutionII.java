package interviews.linkedin._072_Edit_Distance;

public final class SolutionII implements Solution {
  public int minDistance(String word1, String word2) {
    final int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < word2.length(); i++) {
      dp[0][i + 1] = i + 1;
    }

    for (int i = 0; i < word1.length(); ++i) {
      dp[i + 1][0] = i + 1; // remove
      for (int j = 0; j < word2.length(); ++j) {
        if (word1.charAt(i) == word2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, dp[i + 1][j] + 1);
          dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 1] + 1);

        }
      }
    }

    return dp[word1.length()][word2.length()];
  }
}
