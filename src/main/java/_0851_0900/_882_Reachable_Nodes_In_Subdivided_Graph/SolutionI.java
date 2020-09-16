package _0851_0900._882_Reachable_Nodes_In_Subdivided_Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
public final class SolutionI implements Solution {
  /**
   * <a href='https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/discuss/156739/C%2B%2BJavaPython-Dijkstra-%2B-Priority-Queue'></a>
   */
  @Override
  public int reachableNodes(int[][] edges, int M, int N) {
    final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (final int[] e : edges) {
      graph.computeIfAbsent(e[0], k -> new HashMap<>()).put(e[1], e[2]);
      graph.computeIfAbsent(e[1], k -> new HashMap<>()).put(e[0], e[2]);
    }
    int result = 0;
    final boolean[] visited = new boolean[N];
    final Queue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
    pq.add(new int[]{0, M});
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int start = toRemove[0], move = toRemove[1];
      if (visited[start]) continue;
      visited[start] = true;
      result++;
      final Map<Integer, Integer> neighbors = graph.get(start);
      if (neighbors == null) continue;
      for (final var e : neighbors.entrySet()) {
        final int next = e.getKey(), remainPoints = e.getValue();
        if (remainPoints >= 0) {
          if (move - remainPoints > 0 && !visited[next]) {
            pq.add(new int[]{next, move - remainPoints - 1});
          }
          final Map<Integer, Integer> nextNeighbors = graph.get(next);
          if (nextNeighbors != null) {
            nextNeighbors.put(start, nextNeighbors.get(start) - move);
          }
          result += Math.min(move, graph.get(start).get(next));
        }
      }
    }
    return result;
  }
}
