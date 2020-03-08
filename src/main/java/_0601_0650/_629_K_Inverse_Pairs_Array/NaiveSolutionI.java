package _0601_0650._629_K_Inverse_Pairs_Array;

/**
 * @author jacka
 * @version 1.0 on 3/7/2020
 */
public final class NaiveSolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int kInversePairs(final int N, final int K) {
    final int[][] dp = new int[N + 1][K + 1];
    for (int n = 1; n <= N; n++) {
      dp[n][0] = 1;
      for (int k = 1; k <= K; k++) {
        int sum = 0;
        for (int itrK = k; itrK >= Math.max(0, k - (n - 1)); itrK--) {
          sum = safeAdd(sum, dp[n - 1][itrK]);
        }
        dp[n][k] = sum;
      }
    }
    return dp[N][K];
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }

}
