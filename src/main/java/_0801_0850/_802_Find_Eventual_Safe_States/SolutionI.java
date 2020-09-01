package _0801_0850._802_Find_Eventual_Safe_States;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class SolutionI implements Solution {
  private final Set<Integer> pointsLeadsToCycle = new HashSet<>(),
      visited = new HashSet<>();
  private int[][] graph;

  public List<Integer> eventualSafeNodes(int[][] graph) {
    final int n = graph.length;
    this.graph = graph;
    for (int i = 0; i < n; ++i) {
      final Set<Integer> curVisit = new HashSet<>();
      if (leadsToCycle(curVisit, i)) {
        pointsLeadsToCycle.add(i);
      }
    }
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (pointsLeadsToCycle.contains(i)) continue;
      result.add(i);
    }
    return result;
  }

  private boolean leadsToCycle(final Set<Integer> visited, final int i) {
    if (pointsLeadsToCycle.contains(i)) return true;
    if (visited.contains(i)) {
      pointsLeadsToCycle.add(i);
      return true;
    }
    if (this.visited.contains(i)) return false;
    this.visited.add(i);
    visited.add(i);
    for (int next : graph[i]) {
      if (leadsToCycle(visited, next)) {
        pointsLeadsToCycle.add(next);
        visited.remove(i);
        return true;
      }
    }
    visited.remove(i);
    return false;
  }
}
