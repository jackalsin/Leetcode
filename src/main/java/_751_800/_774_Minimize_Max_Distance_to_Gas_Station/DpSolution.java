package _751_800._774_Minimize_Max_Distance_to_Gas_Station;

import java.util.Arrays;

public final class DpSolution implements Solution {

  @Override
  public double minmaxGasDist(int[] stations, int K) {
    final int N = stations.length;
    final double[] distances = new double[N - 1];
    for (int i = 0; i < N - 1; i++) {
      distances[i] = stations[i + 1] - stations[i];
    }

    Arrays.sort(distances);
    /* dp[k][n] denotes the minimum distances adding k stations in the first n distances */
    final double[][] dp = new double[K + 1][distances.length];
    for (int i = 0; i < distances.length; i++) {
      dp[0][i] = distances[i];
    }

    for (int k = 1; k <= K; k++) {
      for (int i = 0; i < distances.length; i++) {
        dp[k][i] = dp[k - 1][i];
        if (i == 0) continue;
        for (int j = 1; j <= k; j++) {
          dp[k][i] = Math.min(dp[k][i], Math.max(dp[k - j][i - 1], distances[i] / (j + 1)));
        }
      }
    }

    return dp[K][distances.length - 1];
  }
}
