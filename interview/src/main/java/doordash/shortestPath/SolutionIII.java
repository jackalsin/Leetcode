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

public final class SolutionIII implements Solution {
  private final Map<Integer, Long> distances = new HashMap<>();
  private final Map<Integer, Map<Integer, Integer>> adjacentList = new HashMap<>();
  private int minDistance = Integer.MAX_VALUE;
  private final Set<Long> shortedPath = new HashSet<>();

  @Override
  public boolean[] isOnShortestPath(int[][] paths, int start, int target) {
    generateAdjacentList(paths);
    generateDistance(start, target);
    final List<Integer> curPath = new ArrayList<>() {{
      add(start);
    }};
    dfs(start, target, 0, curPath);
    return getResult(paths);
  }

  private boolean[] getResult(final int[][] paths) {
    final int n = paths.length;
    final boolean[] result = new boolean[n];
    for (int i = 0; i < n; ++i) {
      final long key = getKey(paths[i][0], paths[i][1]);
      result[i] = shortedPath.contains(key);
    }
    return result;
  }

  private void dfs(final int start, final int end, final long distance, final List<Integer> curPath) {
    if (distance > minDistance) return;
    if (start == end) {
      if (distance < minDistance) {
        minDistance = (int) distance;
        shortedPath.clear();
      }
      for (int i = 1; i < curPath.size(); ++i) {
        shortedPath.add(getKey(curPath.get(i - 1), curPath.get(i)));
      }
      return;
    }
    final int size = curPath.size();
    for (final Map.Entry<Integer, Integer> e : adjacentList.getOrDefault(start, Collections.emptyMap()).entrySet()) {
      final int next = e.getKey(), addedDistance = e.getValue();
      final long nextDistance = addedDistance + distance;
      if (nextDistance == distances.get(next)) {
        curPath.add(next);
        dfs(next, end, nextDistance, curPath);
        curPath.remove(size);
      }
    }
  }

  private static long getKey(final long x, final long y) {
    if (x < y) return getKey(y, x);
    return x << 32 | y;
  }

  private void generateAdjacentList(final int[][] paths) {
    for (final int[] path : paths) {
      final int start = path[0], end = path[1], weight = path[2];
      adjacentList.computeIfAbsent(start, k -> new HashMap<>()).put(end, weight);
      adjacentList.computeIfAbsent(end, k -> new HashMap<>()).put(start, weight);
    }
  }

  private void generateDistance(final int start, final int end) {
    final Queue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])) {{
      add(new long[]{0, start});
    }};
    distances.put(start, 0L);
    while (!q.isEmpty()) {
      final long[] toRemove = q.remove();
      final long dist = toRemove[0];
      final int cur = (int) toRemove[1];
      for (final Map.Entry<Integer, Integer> e : adjacentList.getOrDefault(cur, Collections.emptyMap()).entrySet()) {
        final int next = e.getKey(), d = e.getValue();
        final long nextDistance = dist + d;
        if (!distances.containsKey(next) || distances.get(next) > nextDistance) {
          distances.put(next, nextDistance);
          q.add(new long[]{nextDistance, next});
        }
      }
    }
  }
}
