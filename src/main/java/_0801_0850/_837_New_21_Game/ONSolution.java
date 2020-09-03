package _0801_0850._837_New_21_Game;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class ONSolution implements Solution {
  /**
   * <a href="https://leetcode.com/problems/new-21-game/discuss/132334/One-Pass-DP-O(N)"></a>
   */
  @Override
  public double new21Game(int N, int K, int W) {
    if (K == 0 || N >= K + W) return 1.0;
    final double[] dp = new double[N + 1];
    dp[0] = 1d;
    double wSum = 1, res = 0;
    for (int i = 1; i <= N; ++i) {
      dp[i] = wSum / W;
      if (i < K) {
        wSum += dp[i];
      } else {
        res += dp[i];
      }
      if (i - W >= 0) wSum -= dp[i - W];
    }
    return res;
  }
}
