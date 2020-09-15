package _0851_0900._882_Reachable_Nodes_In_Subdivided_Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int reachableNodes(int[][] edges, int M, int N) {
    final int[][] graph = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(graph[i], -1);
    }
    for (final int[] e : edges) {
      graph[e[0]][e[1]] = e[2];
      graph[e[1]][e[0]] = e[2];
    }
    int result = 0;
    final boolean[] visited = new boolean[N];
    final Queue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
    pq.add(new int[]{0, M});
//    TwoDimensionArray.println(graph);
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int start = toRemove[0], move = toRemove[1];
      if (visited[start]) continue;
      visited[start] = true;
      result++;
      for (int i = 0; i < N; ++i) {
        if (graph[start][i] >= 0 && i != start) {
          if (move - graph[start][i] > 0 && !visited[i]) {
            pq.add(new int[]{i, move - graph[start][i] - 1});
          }
          graph[i][start] -= move;
//          graph[i][start] -= Math.min(move, graph[start][i]);
          result += Math.min(move, graph[start][i]);
        }
      }
//      System.out.println("--------------------------------------");
//      System.out.println(result);
//      pq.forEach(x -> System.out.println(Arrays.toString(x)));
//      TwoDimensionArray.println(graph);
    }
    return result;
  }
}
