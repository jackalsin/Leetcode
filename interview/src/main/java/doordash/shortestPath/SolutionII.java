package doordash.shortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public final class SolutionII implements Solution {
  private final Map<Integer, Map<Integer, Integer>> adjacentList = new HashMap<>();
  private final Map<Integer, Integer> distances = new HashMap<>();
  private final Set<Long> shortestPath = new HashSet<>();
  private int minDistance = Integer.MAX_VALUE;

  @Override
  public boolean[] isOnShortestPath(int[][] paths, int start, int target) {
    // generate adjacent list
    generateAdjacentList(paths);
    // generate distance
    generateDistances(start);
    // dfs
    final List<Integer> curPath = new ArrayList<>() {{
      add(start);
    }};

    dfs(start, target, curPath, 0);
    // generate result
    return getResult(paths);
  }

  private boolean[] getResult(final int[][] paths) {
    final boolean[] result = new boolean[paths.length];
    for (int i = 0; i < paths.length; i++) {
      final int[] p = paths[i];
      result[i] = shortestPath.contains(getKey(p));
    }
    return result;
  }

  private long getKey(final int[] p) {
    return getKey(p[0], p[1]);
  }

  private void dfs(final int start, final int target, final List<Integer> curPath, final int curWeight) {
    if (curWeight > minDistance) return;
    if (start == target) {
      if (curWeight < minDistance) {
        minDistance = curWeight;
        shortestPath.clear();
      }
      for (int i = 1; i < curPath.size(); ++i) {
        shortestPath.add(getKey(curPath.get(i - 1), curPath.get(i)));
      }
      return;
    }

    for (var e : adjacentList.getOrDefault(start, Collections.emptyMap()).entrySet()) {
      final int next = e.getKey(), nextWeight = curWeight + e.getValue();
      if (distances.getOrDefault(next, -1) != nextWeight) continue;
      curPath.add(next);
      dfs(next, target, curPath, nextWeight);
      curPath.remove(curPath.size() - 1);
    }
  }

  private static long getKey(final int p, final int q) {
    if (p > q) return getKey(q, p);
    return ((long) q << 32 | p);
  }

  private void generateDistances(final int start) {
    final Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])) {{
      add(new int[]{start, 0});
    }};
    distances.put(start, 0);
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int cur = toRemove[0], d = toRemove[1];
      if (distances.get(cur) < d) continue;
      for (final var e : adjacentList.getOrDefault(cur, Collections.emptyMap()).entrySet()) {
        final int next = e.getKey(), nextD = d + e.getValue();
        if (!distances.containsKey(next) || distances.get(next) > nextD) {
          distances.put(next, nextD);
          q.add(new int[]{next, nextD});
        }
      }
    }
  }

  private void generateAdjacentList(final int[][] paths) {
    for (final int[] e : paths) {
      final int p = e[0], q = e[1], w = e[2];
      adjacentList.computeIfAbsent(p, k -> new HashMap<>()).put(q, w);
      adjacentList.computeIfAbsent(q, k -> new HashMap<>()).put(p, w);
    }
  }
}
