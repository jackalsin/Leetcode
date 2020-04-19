package _1401_1450._1420_Build_Array_Where_You_Can_Find_The_Maximum_Exactly_K_Comparisons;

public final class BottomUpSolution implements Solution {
  private static final int MOD = 1000000007;

  public int numOfArrays(int N, int M, int K) {
    final long[][][] dp = new long[N + 1][M + 1][K + 1];
    // len 1, max = j, cost 1
    for (int j = 1; j <= M; ++j) {
      dp[1][j][1] = 1;
    }
    for (int n = 1; n <= N; ++n) {
      for (int m = 1; m <= M; ++m) {
        for (int k = 1; k <= K; ++k) {
          // append m at the end of each dp[n - 1][m][k]
          dp[n][m][k] = safeAdd(dp[n][m][k], m * dp[n - 1][m][k]);
          // append m at the end of each dp[n - 1][i][k] where i∈[1, m - 1]
          for (int i = 1; i < m; ++i) {
            dp[n][m][k] = safeAdd(dp[n][m][k], dp[n - 1][i][k - 1]);
          }
        } // end of loop k
      }
    }
    long res = 0;
    for (int m = 1; m <= M; ++m) {
      res = safeAdd(dp[N][m][K], res);
    }
    return (int) res;
  }

  private static long safeAdd(final long a, final long b) {
    return (a + b) % MOD;
  }
}
