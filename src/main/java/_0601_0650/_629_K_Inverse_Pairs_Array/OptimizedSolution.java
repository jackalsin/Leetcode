package _0601_0650._629_K_Inverse_Pairs_Array;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
public final class OptimizedSolution implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int kInversePairs(int N, int K) {
    final int[][] dp = new int[N + 1][K + 1];

    // `dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]`
    // `dp[n][k] = dp[n][k - 1]+dp[n-1][k]-dp[n-1][k-n]`
    for (int n = 1; n <= N; ++n) {
      dp[n][0] = 1;
      for (int k = 1; k <= Math.min(K, n * (n - 1) / 2); k++) {
        int sum = safeAdd(dp[n][k - 1], dp[n - 1][k]);
        if (k >= n) {
          sum = safeAdd(sum, -dp[n - 1][k - n]);
        }
        dp[n][k] = safeAdd(sum, MOD);
      }
    }
    return dp[N][K];
  }

  private static int safeAdd(final int a, final int b) {
    assert a <= MOD && b <= MOD;
    return (a + b) % MOD;
  }
}
