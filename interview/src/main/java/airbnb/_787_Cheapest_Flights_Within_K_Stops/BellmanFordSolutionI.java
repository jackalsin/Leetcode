package airbnb._787_Cheapest_Flights_Within_K_Stops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
public final class BellmanFordSolutionI implements Solution {
  @Override
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final Map<Integer, List<int[]>> map = getFlightMap(flights);
    final int[][] dp = new int[K + 2][n];
    Arrays.fill(dp[0], Integer.MAX_VALUE);
    dp[0][src] = 0;
    for (int k = 0; k < K + 1; ++k) {
      System.arraycopy(dp[k], 0, dp[k + 1], 0, n);
      for (int i = 0; i < n; ++i) {
        if (dp[k][i] == Integer.MAX_VALUE) continue;
        for (final int[] children : map.getOrDefault(i, Collections.emptyList())) {
          final int to = children[0], cost = children[1];
          dp[k + 1][to] = Math.min(dp[k + 1][to], dp[k][i] + cost);
        }
      }
    }
    return dp[K + 1][dst] == Integer.MAX_VALUE ? -1 : dp[K + 1][dst];
  }

  private static Map<Integer, List<int[]>> getFlightMap(final int[][] flights) {
    final Map<Integer, List<int[]>> result = new HashMap<>();
    for (final int[] flight : flights) {
      final int from = flight[0], to = flight[1], cost = flight[2];
      result.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, cost});
    }
    return result;
  }
}
