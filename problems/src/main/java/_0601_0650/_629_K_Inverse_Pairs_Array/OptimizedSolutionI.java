package _0601_0650._629_K_Inverse_Pairs_Array;

/**
 * @author jacka
 * @version 1.0 on 3/7/2020
 */
public final class OptimizedSolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int kInversePairs(int N, int K) {

    final int[][] dp = new int[N + 1][K + 1];
    dp[1][0] = 1;
//    dp[2][0] = 1;
//    dp[2][1] = 1;
    for (int n = 2; n <= N; ++n) {
      dp[n][0] = 1;
      for (int k = 1; k <= Math.min(K, (n - 1) * n / 2); ++k) {
        dp[n][k] = safeAdd(dp[n][k - 1], dp[n - 1][k]);
        if (k >= n) {
          dp[n][k] = safeAdd(dp[n][k], -dp[n - 1][k - n]);
        }
        dp[n][k] = safeAdd(dp[n][k], MOD);
      }
    }
//    TwoDimensionArray.toString(dp);
    return dp[N][K];
  }

  private static int safeAdd(final int a, final int b) {
//    System.out.println("a = " + a + ", b = " + b);
    assert a <= MOD && b <= MOD;
    return (a + b) % MOD;
  }
}
