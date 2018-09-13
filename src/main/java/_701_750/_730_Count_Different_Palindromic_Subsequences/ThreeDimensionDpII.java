package _701_750._730_Count_Different_Palindromic_Subsequences;

public final class ThreeDimensionDpII implements Solution {
  private static final int MOD = 1_000_000_000 + 7;

  @Override
  public int countPalindromicSubsequences(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    final int n = s.length(), dp[][][] = new int[4][n][n];
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i; j < n; ++j) {
        for (int k = 0; k < 4; ++k) {
          final char chr = (char) ('a' + k);
          if (i == j) {
            dp[k][i][j] = (s.charAt(i) == chr) ? 1 : 0;
          } else {
            if (s.charAt(i) != chr && s.charAt(j) != chr) {
              assert dp[k][i + 1][j] == dp[k][i][j - 1]; // why?

              dp[k][i][j] = dp[k][i + 1][j - 1];
            } else if (s.charAt(i) != chr) {
              dp[k][i][j] = dp[k][i + 1][j];
            } else if (s.charAt(j) != chr) {
              dp[k][i][j] = dp[k][i][j - 1];
            } else {
              // 'a' 与 'aa'
              dp[k][i][j] = safeAdd(2, dp[0][i + 1][j - 1], dp[1][i + 1][j - 1], dp[2][i + 1][j - 1], dp[3][i + 1][j - 1]);
            }
          }
        }
      }
    }

//    Arrays.stream(dp).forEach(TwoDimensionArray::display);
    return safeAdd(dp[0][0][n - 1], dp[1][0][n - 1], dp[2][0][n - 1], dp[3][0][n - 1]);
  }

  private static int safeAdd(int a, int... b) {
    int res = a;
    for (int num : b) {
      res = (res + num) % MOD;
    }
    return res;
  }
}
