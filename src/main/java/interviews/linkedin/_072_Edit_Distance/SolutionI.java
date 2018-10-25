package interviews.linkedin._072_Edit_Distance;

public final class SolutionI implements Solution {
  public int minDistance(String word1, String word2) {
    final int[][] dp = new int[word2.length() + 1][word1.length() + 1];
    for (int i = 0; i < word1.length(); ++i) {
      dp[0][i + 1] = i + 1;
    }

    for (int i = 0; i < word2.length(); ++i) {
      dp[i + 1][0] = dp[i][0] + 1;
      for (int j = 0; j < word1.length(); ++j) {
        dp[i + 1][j + 1] = Math.min(dp[i][j] + (word2.charAt(i) == word1.charAt(j) ? 0 : 1), Math.min(dp[i][j + 1], dp[i + 1][j]) + 1);
      }
    }
    return dp[word2.length()][word1.length()];
  }
}
