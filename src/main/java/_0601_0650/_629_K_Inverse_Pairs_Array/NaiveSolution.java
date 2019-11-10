package _0601_0650._629_K_Inverse_Pairs_Array;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
public final class NaiveSolution implements Solution {
  private static final int MOD = (int) (1e9 + 7);

  public int kInversePairs(final int N, final int K) {
    if (N == 0 && K == 0) {
      return 1;
    }
    final int[][] dp = new int[N + 1][K + 1];
    dp[0][0] = 0;
    for (int n = 1; n < N + 1; n++) {
      dp[n][0] = 1;
      for (int k = 1; k < K + 1; k++) {
        int sum = 0;
        for (int i = Math.max(0, k - (n - 1)); i <= k; ++i) {
          sum = safeAdd(sum, dp[n - 1][i]);
        }
        dp[n][k] = sum;
      }
    }
    return dp[N][K];
  }

  private static int safeAdd(int a, int b) {
    assert a <= MOD && b <= MOD;
    return (a + b) % MOD;
  }
}
