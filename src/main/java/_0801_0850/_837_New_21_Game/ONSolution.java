package _0801_0850._837_New_21_Game;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class ONSolution implements Solution {
  /**
   * It stops when >= K, ask for the probability <= N;
   * <a href="https://leetcode.com/problems/new-21-game/discuss/132334/One-Pass-DP-O(N)"></a>
   */
  @Override
  public double new21Game(int N, int K, int W) {
    if (K == 0 || N >= K + W) return 1d;
    final double[] dp = new double[N + 1];
    dp[0] = 1d;
    double lastWSum = 1d, result = 0;
    for (int i = 1; i <= N; ++i) {
      dp[i] = lastWSum / W;
      if (i < K) {
        lastWSum += dp[i];
      } else {
        result += dp[i];
      }
      if (i >= W) {
        lastWSum -= dp[i - W];
      }
    }
//    System.out.println(Arrays.toString(dp));
    return result;
  }
}
