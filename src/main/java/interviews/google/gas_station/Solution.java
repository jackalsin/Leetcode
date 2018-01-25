package interviews.google.gas_station;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/24/2018.
 */
public class Solution {

  public double minimizeGasStation(final int[] gas, final int K) {
    assert gas.length >= 2;
    final double[] distances = new double[gas.length];

    for (int i = 0; i + 1 < gas.length; i++) {
      distances[i] = gas[i + 1] - gas[i];
    }
    Arrays.sort(distances);
    final double[][] dp = new double[K + 1][distances.length];
    for (int i = 0; i < distances.length; i++) {
      dp[0][i] = distances[i];
    }
    for (int k = 1; k <= K; k++) {
      for (int i = 0; i < distances.length; i++) {
        dp[k][i] = dp[k - 1][i];
        if (i == 0) {
          continue;
        }
        for (int j = 1; j <= k; j++) {
          dp[k][i] = Math.min(dp[k][i], Math.max(dp[k - j][i - 1], distances[i] / (j + 1)));
        }
      }
    }
    return dp[K][distances.length - 1];
  }

}
