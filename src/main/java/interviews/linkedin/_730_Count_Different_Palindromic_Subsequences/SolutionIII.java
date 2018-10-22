package interviews.linkedin._730_Count_Different_Palindromic_Subsequences;

public final class SolutionIII implements Solution {
  private static final int BASE = (int) 1E9 + 7, CHARS = 4;

  public int countPalindromicSubsequences(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    final int[][][] dp = new int[4][s.length()][s.length()];
    final int N = s.length();
    for (int i = N - 1; i >= 0; --i) {
      for (int k = 0; k < CHARS; ++k) {
        dp[k][i][i] = s.charAt(i) == (char) (k + 'a') ? 1 : 0;
      }
      for (int j = i + 1; j < N; ++j) {

        for (int k = 0; k < CHARS; ++k) {
          final char chr = (char) ('a' + k);
          if (s.charAt(i) == chr && chr == s.charAt(j)) {
            dp[k][i][j] = 2;
            for (int l = 0; l < CHARS; ++l) {
              dp[k][i][j] = safeAdd(dp[k][i][j], dp[l][i + 1][j - 1]);
            }
          } else if (s.charAt(i) == chr) {
            dp[k][i][j] = dp[k][i][j - 1];
          } else if (s.charAt(j) == chr) {
            dp[k][i][j] = dp[k][i + 1][j];
          } else {
            dp[k][i][j] = dp[k][i + 1][j - 1];
          }
        }

      }
    }

    int res = 0;
    for (int i = 0; i < CHARS; i++) {
      res = safeAdd(res, dp[i][0][s.length() - 1]);
    }
    return res;
  }

  private static int safeAdd(int a, int... nums) {
    int sum = a;
    for (int i : nums) {
      sum = (sum + i) % BASE;
    }
    return sum;
  }
}
