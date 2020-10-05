package _0751_0800._787_Cheapest_Flights_Within_K_Stops;

import java.util.Arrays;

public final class BellmantFordSolution implements Solution {
  /**
   * Time complexity: O(len(n), len(k) * len(flights))
   *
   * @param n
   * @param flights
   * @param src
   * @param dst
   * @param K
   * @return
   */
  @Override
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);

    distances[src] = 0;
    for (int k = 0; k <= K; ++k) {
      final int[] tmp = new int[n];
      System.arraycopy(distances, 0, tmp, 0, n);
      for (final int[] f : flights) {
        // src, dst, price
        final int cur = f[0], next = f[1], price = f[2];
        if (distances[cur] == Integer.MAX_VALUE) {
          continue;
        }
        tmp[next] = Math.min(distances[cur] + price, tmp[next]);
      }
      System.arraycopy(tmp, 0, distances, 0, n);

    }
    return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
  }
}
