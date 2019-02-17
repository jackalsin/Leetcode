package interviews.airbnb._787_Cheapest_Flights_Within_K_Stops;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
public final class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final int[][] dp = new int[K + 2][n];
    Arrays.fill(dp[0], Integer.MAX_VALUE);
    dp[0][src] = 0;
    for (int k = 1; k < K + 2; k++) {
      System.arraycopy(dp[k - 1], 0, dp[k], 0, n);

      for (int[] f : flights) {
        final int from = f[0], to = f[1], price = f[2];
        if (dp[k - 1][from] == Integer.MAX_VALUE) continue;
        dp[k][to] = Math.min(dp[k][to], dp[k - 1][from] + price);
      }
    }
    return dp[K + 1][dst] == Integer.MAX_VALUE ? -1 : dp[K + 1][dst];
  }
}
