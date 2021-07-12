package doordash.shortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public final class SolutionI implements Solution {
  private int minWeightPath = Integer.MAX_VALUE;

  @Override
  public boolean[] isOnShortestPath(final int[][] paths, final int start, final int target) {
    if (paths == null || paths.length == 0) return new boolean[0];
    // generate adjacent list
    final Map<Integer, Map<Integer, Integer>> adjacentList = getAdjacentList(paths);

    // generate distance
    final Map<Integer, Integer> distances = getDistances(adjacentList, start);

    final Set<Long> result = new HashSet<>();
    final List<Integer> curPath = new ArrayList<>() {{
      add(start);
    }};
    dfs(adjacentList, distances, result, start, target, curPath, 0);
    return getResult(result, paths);
  }

  private static boolean[] getResult(final Set<Long> shortestEdges, final int[][] paths) {
    final int n = paths.length;
    final boolean[] result = new boolean[n];
    for (int i = 0; i < paths.length; i++) {
      final int[] p = paths[i];
      result[i] = shortestEdges.contains(getKey(p));
    }
    return result;
  }

  private void dfs(final Map<Integer, Map<Integer, Integer>> adjacentList,
                   final Map<Integer, Integer> distances, final Set<Long> result,
                   final int start, final int end, final List<Integer> curPath, final int curWeight) {
    if (curWeight > minWeightPath) return;
    if (start == end) {
      if (curWeight < minWeightPath) {
        minWeightPath = curWeight;
        result.clear();
      }
      for (int i = 1; i < curPath.size(); ++i) {
        result.add(getKey(curPath.get(i - 1), curPath.get(i)));
      }
      return;
    } // end of start == end;
    final int size = curPath.size();
    for (var e : adjacentList.getOrDefault(start, Collections.emptyMap()).entrySet()) {
      final int next = e.getKey(), w = e.getValue() + curWeight;
      if (distances.getOrDefault(next, -1) == w) {
        curPath.add(next);
        dfs(adjacentList, distances, result, next, end, curPath, w);
        curPath.remove(size);
      }
    }
  }

  private static Map<Integer, Integer> getDistances(final Map<Integer, Map<Integer, Integer>> adjacentList,
                                                    final int start) {
    final Map<Integer, Integer> distances = new HashMap<>() {{
      put(start, 0);
    }};
    final Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])) {{
      add(new int[]{start, 0});
    }};
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int cur = toRemove[0], weight = toRemove[1];
      for (final Map.Entry<Integer, Integer> e : adjacentList.getOrDefault(cur, Collections.emptyMap()).entrySet()) {
        final int next = e.getKey(), nextWeight = e.getValue() + weight;
        if (!distances.containsKey(next) || distances.get(next) > nextWeight) {
          distances.put(next, nextWeight);
          q.add(new int[]{next, nextWeight});
        }
      }
    }
    return distances;
  }

  private Map<Integer, Map<Integer, Integer>> getAdjacentList(final int[][] paths) {
    final Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
    for (final int[] path : paths) {
      final int p = path[0], q = path[1], w = path[2];
      result.computeIfAbsent(p, k -> new HashMap<>()).put(q, w);
      result.computeIfAbsent(q, k -> new HashMap<>()).put(p, w);
    }
    return result;
  }

  private static long getKey(final int[] edge) {
    return getKey(edge[0], edge[1]);
  }

  private static long getKey(final int p, final int q) {
    if (p > q) return getKey(q, p);
    return ((long) p << 32) | q;
  }
}