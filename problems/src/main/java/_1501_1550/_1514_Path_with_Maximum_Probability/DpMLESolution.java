package _1501_1550._1514_Path_with_Maximum_Probability;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/20/2021
 */
public final class DpMLESolution implements Solution {
  @Override
  public double maxProbability(int n, int[][] edges, double[] succProb,
                               int start, int end) {
    final Map<Integer, Map<Integer, Double>> srcToDst = getEdges(edges, succProb);
    final double[][] dp = new double[n][n];
    dp[0][start] = 1;
    for (int i = 0; i < n - 1; ++i) {
      System.arraycopy(dp[i], 0, dp[i + 1], 0, n);
      for (int j = 0; j < n; ++j) {
        if (dp[i][j] == 0) continue;
        final Map<Integer, Double> dstToRatio = srcToDst.getOrDefault(j, new HashMap<>());
        for (final var e : dstToRatio.entrySet()) {
          final int dst = e.getKey();
          final double ratio = e.getValue();
          dp[i + 1][dst] = Math.max(dp[i + 1][dst], dp[i][j] * ratio);
        }
      }
    }
//    TwoDimensionArray.println(dp);
    return dp[n - 1][end];
  }

  private static Map<Integer, Map<Integer, Double>> getEdges(final int[][] edges, final double[] succProb) {
    final Map<Integer, Map<Integer, Double>> result = new HashMap<>();
    for (int i = 0; i < edges.length; ++i) {
      final int[] edge = edges[i];
      final int src = edge[0], dst = edge[1];
      final double ratio = succProb[i];
      result.computeIfAbsent(src, k -> new HashMap<>()).put(dst, ratio);
      result.computeIfAbsent(dst, k -> new HashMap<>()).put(src, ratio);
    }
    return result;
  }
}
