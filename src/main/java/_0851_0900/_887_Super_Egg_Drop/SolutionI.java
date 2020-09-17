package _0851_0900._887_Super_Egg_Drop;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
public final class SolutionI implements Solution {
  /**
   * @param K Number of eggs
   * @param N Floor
   */
  @Override
  public int superEggDrop(int K, int N) {
    /*
     * The dp equation is:
     * dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
     * assume, dp[m-1][k-1] = n0, dp[m-1][k] = n1
     * the first floor to check is n0+1.
     * if egg breaks, F must be in [1,n0] floors, we can use m-1 moves and k-1 eggs to find out F is which one.
     * if egg doesn't breaks and F is in [n0+2, n0+n1+1] floors, we can use m-1 moves and k eggs to find out F is
     * which one.
     * So, with m moves and k eggs, we can find out F in n0+n1+1 floors, whichever F is.
     */
    final int[][] dp = new int[N + 1][K + 1];
    for (int m = 1; m <= N; ++m) {
      for (int k = 1; k <= K; ++k) {
        dp[m][k] = 1 + dp[m - 1][k - 1] + dp[m - 1][k];
        if (dp[m][k] >= N) {
          return m; // minimum step
        }
      }
    }
    return dp[N][K];
  }
}
