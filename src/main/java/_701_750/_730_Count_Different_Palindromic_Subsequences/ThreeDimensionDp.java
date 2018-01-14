package _701_750._730_Count_Different_Palindromic_Subsequences;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public final class ThreeDimensionDp implements Solution {
  private int[][][] dp;
  private static final int MOD = (int) ((1E9) + 7);

  @Override
  public int countPalindromicSubsequences(String s) {
    final int N = s.length();
    dp = new int[4][N][N];
    for (int i = N - 1; i >= 0; i--) {
      for (int j = i; j < N; j++) {
        for (int k = 0; k < 4; k++) {
          final char chr = (char) (k + 'a');
          if (i == j) {
            dp[k][i][j] = chr == s.charAt(i) ? 1 : 0;
          } else if (s.charAt(i) != chr) {
            dp[k][i][j] = dp[k][i + 1][j];
          } else if (s.charAt(j) != chr) {
            dp[k][i][j] = dp[k][i][j - 1];
          } else {
            dp[k][i][j] = 2;
            for (int m = 0; m < 4; m++) {
              dp[k][i][j] = getModSum(dp[k][i][j], dp[m][i + 1][j - 1]);
            }
          }
        }
      }
    }
    int res = 0;
    for (int k = 0; k < 4; k++) {
      res = getModSum(res, dp[k][0][N - 1]);
    }
    return res;
  }

  static int getModSum(int cur, int... ops) {
    for (int opt : ops) {
      cur += opt;
      cur %= MOD;
    }
    return cur;
  }

}
