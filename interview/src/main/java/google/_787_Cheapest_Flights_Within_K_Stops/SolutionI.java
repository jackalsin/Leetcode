package google._787_Cheapest_Flights_Within_K_Stops;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final int[][] costs = new int[K + 2][n];
    Arrays.fill(costs[0], Integer.MAX_VALUE);
    costs[0][src] = 0;
    for (int k = 1; k < K + 2; ++k) {
      System.arraycopy(costs[k - 1], 0, costs[k], 0, n);
      for (final int[] flight : flights) {
        final int start = flight[0], end = flight[1], cost = flight[2];
        if (costs[k - 1][start] == Integer.MAX_VALUE) continue;
        costs[k][end] = Math.min(costs[k][end], costs[k - 1][start] + cost);
      }
    }
    return costs[K + 1][dst] == Integer.MAX_VALUE ? -1 : costs[K + 1][dst];
  }
}
