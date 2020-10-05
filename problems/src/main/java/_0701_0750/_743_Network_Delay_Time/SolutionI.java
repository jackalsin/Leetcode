package _0701_0750._743_Network_Delay_Time;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/31/2020
 */
public final class SolutionI implements Solution {

  public int networkDelayTime(int[][] times, int N, int K) {
    final int[][] distances = new int[N + 1][N + 1];
    for (final int[] d : distances) {
      Arrays.fill(d, Integer.MAX_VALUE);
    }
    distances[0][K] = 0;
    for (int i = 0; i < N; ++i) {
      System.arraycopy(distances[i], 0, distances[i + 1], 0, N + 1);
      for (final int[] t : times) {
        final int from = t[0], to = t[1], time = t[2];
        if (distances[i][from] == Integer.MAX_VALUE) continue;
        distances[i + 1][to] = Math.min(distances[i + 1][to], distances[i][from] + time);
      }
    }
//    TwoDimensionArray.toString(distances);
    int max = 0;
    for (int i = 0; i < N; i++) {
      if (distances[N][i + 1] == Integer.MAX_VALUE) return -1;
      max = Math.max(max, distances[N][i + 1]);
    }
    return max;
  }
}
