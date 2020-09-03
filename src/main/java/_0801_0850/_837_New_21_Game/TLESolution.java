package _0801_0850._837_New_21_Game;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class TLESolution implements Solution {

  public double new21Game(int N, int K, int W) {
    final int len = Math.max(N + 1, K);
    double[] dp = new double[len + 1];
    dp[0] = 1d;
    double sum = 0;
    for (int col = K; col <= N; ++col) {
      sum += dp[col];
    }
    for (int n = 1; n <= N; ++n) {
      final double[] next = new double[len + 1];
      for (int prev = 0; prev < K; ++prev) {
        for (int choose = 1; choose <= W; ++choose) {
          final int index = Math.min(prev + choose, len);
          next[index] += 1d / W * dp[prev];
        }
      } // end of for prev
      dp = next;
      for (int col = K; col <= N; ++col) {
        sum += dp[col];
      }
    }
    return sum;
  }
}
