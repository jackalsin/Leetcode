package _1501_1550._1514_Path_with_Maximum_Probability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/21/2021
 */
public final class BellmanFordPassSolution implements Solution {
  @Override
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    final Map<Integer, List<int[]>> srcToDst = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      final int[] edge = edges[i];
      final int a = edge[0], b = edge[1];
      srcToDst.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[]{b, i});
      srcToDst.computeIfAbsent(b, k -> new ArrayList<>()).add(new int[]{a, i});
    }
    final double[] prob = new double[n];
    prob[start] = 1d;
    final Queue<Integer> pq = new PriorityQueue<>() {{
      add(start);
    }};
    while (!pq.isEmpty()) {
      final int toRemove = pq.remove();
      for (final int[] e : srcToDst.getOrDefault(toRemove, Collections.emptyList())) {
        final int next = e[0], i = e[1];
        if (prob[next] < succProb[i] * prob[toRemove]) {
          prob[next] = succProb[i] * prob[toRemove];
          pq.add(next);
        }
      }
    }
    return prob[end];
  }
}
