package doordash.shortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/2/2021
 */
public final class BfsDfsSolution implements Solution {
  private int minSize = Integer.MAX_VALUE;
  private final Set<Edge> result = new HashSet<>();
  private final Map<Integer, List<Integer>> neighbors = new HashMap<>();
  private final Map<Integer, Integer> distances = new HashMap<>();

  @Override
  public Set<Edge> shortestPathEdges(List<Edge> edges, int start, int end) {
    generateAdjacentList(edges);
    bfsGenerateDistance(start);
    final List<Integer> curPath = new ArrayList<>() {{
      add(start);
    }};
    dfs(start, end, curPath);
    return result;
  }

  private void dfs(final int start, final int end, final List<Integer> curPath) {
    if (curPath.size() > minSize) return;
    if (start == end) {
      if (curPath.size() < minSize) {
        minSize = curPath.size();
        result.clear();
      }
      for (int i = 1; i < curPath.size(); ++i) {
        result.add(Edge.of(curPath.get(i - 1), curPath.get(i)));
      }
      return;
    }
    final int curStep = curPath.size();
    final List<Integer> neighbors = this.neighbors.getOrDefault(start, Collections.emptyList());
    for (final int neighbor : neighbors) {
      if (distances.getOrDefault(neighbor, Integer.MAX_VALUE) != curStep) continue;
      curPath.add(neighbor);
      dfs(neighbor, end, curPath);
      curPath.remove(curPath.size() - 1);
    }
  }

  private void generateAdjacentList(final List<Edge> edges) {
    for (final Edge edge : edges) {
      final int p = edge.either(), q = edge.other(p);
      neighbors.computeIfAbsent(p, k -> new ArrayList<>()).add(q);
      neighbors.computeIfAbsent(q, k -> new ArrayList<>()).add(p);
    }
  }

  private void bfsGenerateDistance(final int start) {
    distances.put(start, 0);
    final Queue<Integer> q = new ArrayDeque<>() {{
      add(start);
    }};
    int step = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final int cur = q.remove();
        distances.put(cur, step);
        final List<Integer> next = neighbors.getOrDefault(cur, Collections.emptyList());
        for (final int n : next) {
          if (distances.containsKey(n)) continue;
          q.add(n);
        }
      } // end of for size
      step++;
    }
  }
}
