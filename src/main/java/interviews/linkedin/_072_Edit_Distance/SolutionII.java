package interviews.linkedin._072_Edit_Distance;

public final class SolutionII implements Solution {
  public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) {
      return 0;
    } else if (word1 == null) {
      return word2.length();
    } else if (word2 == null) {
      return word1.length();
    }
    final int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word2.length(); i++) {
      dp[0][i] = i;
    }
    for (int i = 0; i < word1.length(); i++) {
      dp[i + 1][0] = i + 1;
      final char chr1 = word1.charAt(i);
      for (int j = 0; j < word2.length(); j++) {
        final char chr2 = word2.charAt(j);
        dp[i + 1][j + 1] = min(dp[i][j] + (chr1 == chr2 ? 0 : 1), dp[i + 1][j] + 1, dp[i][j + 1] + 1);
      }
    }
    return dp[word1.length()][word2.length()];
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(a, c);
    }
    return a;
  }
}
