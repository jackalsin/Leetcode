package _0801_0850._837_New_21_Game;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class MLESolution implements Solution {

  public double new21Game(int N, int K, int W) {
    final int len = Math.max(N + 1, K);
    final double[][] dp = new double[N + 1][len + 1];
    dp[0][0] = 1d;
    for (int n = 1; n <= N; ++n) {
      for (int prev = 0; prev < K; ++prev) {
        for (int choose = 1; choose <= W; ++choose) {
          final int index = Math.min(prev + choose, len);
          dp[n][index] += 1d / W * dp[n - 1][prev];
        }
      }
    }
    double sum = 0;
    for (int row = 0; row <= N; ++row) {
      for (int col = K; col <= N; ++col) {
        sum += dp[row][col];
      }
    }
    return sum;
  }
}
