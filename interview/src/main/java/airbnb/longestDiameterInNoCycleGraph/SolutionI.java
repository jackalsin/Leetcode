package airbnb.longestDiameterInNoCycleGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SolutionI implements Solution {
  @Override
  public int getLongestDiameterOfGraph(int[][] edges) {
    // 解法说明
    // 统计graph，从任意一点出发dfs到最远的一点(s, t)
    // 从该点出发，则到达最远的一点为另一端点

    // 证明：
    //    证明的命题：当任意一点P进行BFS最终点必然是s 或者 t
    //    反证： 如果不是，假设该点为m
    //
    //        则有
    //    p-> m距离为x1
    //    p-> s 距离为x2
    //    p-> t 距离为x3
    //
    //    则会有 x1+ x2 > x2 + x3, x2 + x3 并不是最长的距离
    final Map<Integer, List<Integer>> parentToChildren = getGraph(edges);
    // furthest point

    int[] furthestAndDistance = null;
    for (int k : parentToChildren.keySet()) {
      furthestAndDistance = dfs(parentToChildren, k, new HashSet<>());
    }

    assert furthestAndDistance != null;
    // find the start;

    final int[] res = dfs(parentToChildren, furthestAndDistance[0], new HashSet<>());
    assert res != null;
    return res[1];
  }

  /**
   * @param parentToChildren
   * @param start
   * @param visited
   * @return {furthest_point, distance}
   */
  private static int[] dfs(final Map<Integer, List<Integer>> parentToChildren, final int start,
                           final Set<Integer> visited) {
    if (visited.contains(start)) {
      return null;
    }
    visited.add(start);
    final int[] res = {start, 0};
    final List<Integer> next = parentToChildren.getOrDefault(start, new ArrayList<>());
    for (int n : next) {
      final int[] curRes = dfs(parentToChildren, n, visited);
      if (curRes == null) continue;
      if (curRes[1] + 1 >= res[1]) {
        System.arraycopy(curRes, 0, res, 0, 2);
        res[1]++;
      }
    }
    return res;
  }

  private static Map<Integer, List<Integer>> getGraph(final int[][] edges) {
    final Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      for (int j = 0; j < edges.length; j++) {
        if (edges[i][j] == 1) {
          map.computeIfAbsent(i, x -> new ArrayList<>()).add(j);
        }
      }
    }
    return map;
  }
}
