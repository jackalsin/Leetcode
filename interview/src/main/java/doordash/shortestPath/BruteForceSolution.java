package doordash.shortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/1/2021
 */
public final class BruteForceSolution implements Solution {
  private int minEdges = Integer.MAX_VALUE;
  private final Set<Edge> result = new HashSet<>();
  private final Map<Integer, List<Edge>> adjacentList = new HashMap<>();

  @Override
  public Set<Edge> shortestPathEdges(final List<Edge> edges, int start, int end) {
    generateAdjacentList(edges);
    final Set<Integer> visited = new HashSet<>();
    dfs(end, start, visited, new ArrayList<>());
    return result;
  }

  private void dfs(final int end, final int cur, final Set<Integer> visitedInPath,
                   final List<Edge> curPath) {
    if (curPath.size() > minEdges) return;
    if (visitedInPath.contains(cur)) return;
    if (cur == end) {
      if (curPath.size() < minEdges) {
        result.clear();
      }
      result.addAll(curPath);
      minEdges = curPath.size();
      return;
    }
    visitedInPath.add(cur);
    for (final Edge e : adjacentList.getOrDefault(cur, Collections.emptyList())) {
      curPath.add(e);
      dfs(end, e.other(cur), visitedInPath, curPath);
      curPath.remove(curPath.size() - 1);
    }
    visitedInPath.remove(cur);
  }

  private void generateAdjacentList(final List<Edge> edges) {
    for (final Edge e : edges) {
      final int p = e.either(), q = e.other(p);
      adjacentList.computeIfAbsent(p, k -> new ArrayList<>()).add(e);
      adjacentList.computeIfAbsent(q, k -> new ArrayList<>()).add(e);
    }
  }
}
