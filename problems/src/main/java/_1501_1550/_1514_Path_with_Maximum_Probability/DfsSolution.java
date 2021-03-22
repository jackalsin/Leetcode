package _1501_1550._1514_Path_with_Maximum_Probability;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/20/2021
 */
public final class DfsSolution implements Solution {
  @Override
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    final Map<Integer, Map<Integer, Double>> srcToDst = getMap(edges, succProb);
    final Queue<Record> pq = new PriorityQueue<>((x, y) -> Double.compare(y.ratio, x.ratio));
    pq.add(new Record(start, 1));
    final Map<Integer, Double> visited = new HashMap<>();
    while (!pq.isEmpty()) {
      final Record toRemove = pq.remove();
      final Map<Integer, Double> neighbors = srcToDst.getOrDefault(toRemove.point, new HashMap<>());
      for (final Map.Entry<Integer, Double> neighbor : neighbors.entrySet()) {
        final int nei = neighbor.getKey();
        final double nextProb = neighbor.getValue() * toRemove.ratio;
        if (visited.getOrDefault(nei, 0d) < nextProb) {
          visited.put(nei, nextProb);
          pq.add(new Record(nei, nextProb));
        }
      }
    }
    return visited.getOrDefault(end, 0d);
  }

  private static Map<Integer, Map<Integer, Double>> getMap(final int[][] edges, final double[] succProb) {
    final int n = edges.length;
    final Map<Integer, Map<Integer, Double>> result = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      final int edge[] = edges[i], src = edge[0], dst = edge[1];
      result.computeIfAbsent(src, k -> new HashMap<>()).put(dst, succProb[i]);
      result.computeIfAbsent(dst, k -> new HashMap<>()).put(src, succProb[i]);
    }
    return result;
  }

  private static final class Record {
    private final int point;
    private final double ratio;

    private Record(int point, double ratio) {
      this.point = point;
      this.ratio = ratio;
    }
  }
}
