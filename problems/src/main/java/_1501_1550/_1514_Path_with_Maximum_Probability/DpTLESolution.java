package _1501_1550._1514_Path_with_Maximum_Probability;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/20/2021
 */
public final class DpTLESolution implements Solution {
  @Override
  public double maxProbability(int n, int[][] edges, double[] succProb,
                               int start, int end) {
    final Map<Integer, Map<Integer, Double>> srcToDst = getEdges(edges, succProb);
    final double[] src = new double[n];
    src[start] = 1;
    for (int i = 0; i < n - 1; ++i) {
      final double[] next = new double[n];
//      System.arraycopy(src, 0, next, 0, n);
      for (int j = 0; j < n; ++j) {
        next[j] = Math.max(src[j], next[j]);
        if (src[j] < src[end]) continue;
        final Map<Integer, Double> dstToRatio = srcToDst.getOrDefault(j, new HashMap<>());
        for (final var e : dstToRatio.entrySet()) {
          final int dst = e.getKey();
          final double ratio = e.getValue();
          next[dst] = Math.max(next[dst], src[j] * ratio);
        }
      }
      System.arraycopy(next, 0, src, 0, n);
    }
//    TwoDimensionArray.println(dp);
    return src[end];
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
