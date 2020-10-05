package linkedin._072_Edit_Distance;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) {
      return 0;
    }
    if (word2 == null) {
      return word1.length();
    }
    if (word1 == null) {
      return word2.length();
    }
    final int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < word2.length(); ++i) {
      dp[0][i + 1] = i + 1;
    }
    for (int i = 0; i < word1.length(); ++i) {
      dp[i + 1][0] = i + 1;
      final char iChar = word1.charAt(i);
      for (int j = 0; j < word2.length(); ++j) {
        final char jChar = word2.charAt(j);
        dp[i + 1][j + 1] = dp[i][j] + (iChar == jChar ? 0 : 1);
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 1][j] + 1);
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 1] + 1);
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
