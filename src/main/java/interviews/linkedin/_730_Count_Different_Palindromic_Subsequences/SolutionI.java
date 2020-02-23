package interviews.linkedin._730_Count_Different_Palindromic_Subsequences;

import utils.TwoDimensionArray;

public final class SolutionI implements Solution {
  private static final int BASE = 1_000_000_000 + 7;

  public int countPalindromicSubsequences(String s) {
    final int n = s.length();
    final int[][][] dp = new int[4][n][n];
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i; j < n; ++j) {
        for (int k = 0; k < 4; k++) {
          final char chr = (char) ('a' + k);
          if (i == j) {
            dp[k][i][j] = s.charAt(i) == chr ? 1 : 0;
          } else {
            // TODO: Correct it
            if (s.charAt(i) != chr) {
              dp[k][i][j] = dp[k][i + 1][j];
            } else if (s.charAt(j) != chr) {
              dp[k][i][j] = dp[k][i][j - 1];
            } else {
              if (i + 1 == j) {
                dp[k][i][j] = 2;
              } else {
                dp[k][i][j] = safeAdd(2,
                    dp[0][i + 1][j - 1], dp[1][i + 1][j - 1],
                    dp[2][i + 1][j - 1], dp[3][i + 1][j - 1]
                );
              }
            }
          } // end of else of i == j;
        }
      }
    }

    for (int i = 0; i < 4; i++) {
      TwoDimensionArray.toString(dp[i]);
    }

    return safeAdd(dp[0][0][n - 1], dp[1][0][n - 1], dp[2][0][n - 1],
        dp[3][0][n - 1]);
  }

  private static int safeAdd(final int a, final int... b) {
    int res = a;
    for (int num : b) {
      res = (res + num) % BASE;
    }
    return res;
  }

}
