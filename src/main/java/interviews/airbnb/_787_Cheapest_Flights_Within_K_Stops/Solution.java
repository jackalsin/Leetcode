package interviews.airbnb._787_Cheapest_Flights_Within_K_Stops;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
public final class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[src] = 0;
    for (int k = 1; k < K + 2; k++) {
      final int[] tmp = new int[n];
      System.arraycopy(dp, 0, tmp, 0, n);

      for (int[] f : flights) {
        final int from = f[0], to = f[1], price = f[2];
        if (dp[from] == Integer.MAX_VALUE) continue;
        tmp[to] = Math.min(tmp[to], dp[from] + price);
      }
      dp = tmp;
    }
    return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
  }
}
