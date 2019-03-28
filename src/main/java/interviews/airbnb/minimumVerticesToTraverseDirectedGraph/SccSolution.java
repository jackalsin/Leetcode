package interviews.airbnb.minimumVerticesToTraverseDirectedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SccSolution implements Solution {
  public List<Integer> getMin(int[][] edges, int n) {
    final Map<Integer, List<Integer>> graph = getGraph(edges);

    // find all scc
    final Deque<Integer> stack = new ArrayDeque<>();
    final Set<Integer> visited = new HashSet<>();

    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) {
        continue;
      }
      dfs(graph, i, stack, visited);
    }

    // reverse graph
    final Map<Integer, List<Integer>> reverseGraph = reverseGraph(edges);
    visited.clear();

    final List<Set<Integer>> scc = new ArrayList<>();
    while (!stack.isEmpty()) {
      final int vertex = stack.pop();
      if (visited.contains(vertex)) {
        continue;
      }
      final Set<Integer> set = new HashSet<>();
      dfsUtilForReverseGraph(reverseGraph, vertex, visited, set);
      scc.add(set);
    }

    System.out.println(scc);

    // 统计入度
    final int[] inDegrees = new int[scc.size()];
    final Set<Integer> toRemoveSccIndex = new HashSet<>();
    int standAlone = scc.size();
    for (int i = 0; i < scc.size(); i++) {
      final Set<Integer> s = scc.get(i);
      toLoop:
      for (int to : s) {
        for (int from = 0; from < n; from++) {
          if (edges[from][to] == 1 && !s.contains(from)) {
            inDegrees[i]++;
            standAlone--;
            toRemoveSccIndex.add(i);
            break toLoop;
          }
        }
      }
    }
    System.out.println(standAlone);
    //
    final Set<Integer> res = new HashSet<>();
    for (int i = 0; i < scc.size(); i++) {
      if (toRemoveSccIndex.contains(i)) continue;
      final Set<Integer> s = scc.get(i);
      for (int c : s) {
        res.add(c);
        break;
      }
    }

//    visited.clear();
//    final Set<Integer> resultSet = new HashSet<>(res);
//    for (int i : res) {
//      if (visited.contains(i)) continue;
//      dfsRemove(graph, resultSet, visited, i);
//    }
    final List<Integer> result = new ArrayList<>(res);
    Collections.sort(result);
    return result;
  }

  private void dfsRemove(Map<Integer, List<Integer>> graph, Set<Integer> result, Set<Integer> visited, int cur) {
    for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
      if (visited.contains(next)) continue;
      visited.add(next);
      result.remove(next);
      dfsRemove(graph, result, visited, next);
    }
  }

  private static void dfsUtilForReverseGraph(final Map<Integer, List<Integer>> reverseGraph, final int vertex,
                                             final Set<Integer> visited, final Set<Integer> set) {
    visited.add(vertex);
    set.add(vertex);
    for (int v : reverseGraph.getOrDefault(vertex, new ArrayList<>())) {
      if (visited.contains(v)) {
        continue;
      }
      dfsUtilForReverseGraph(reverseGraph, v, visited, set);
    }
  }


  private static void dfs(final Map<Integer, List<Integer>> g, int cur, final Deque<Integer> stack,
                          final Set<Integer> visited) {
    visited.add(cur);
    for (int v : g.getOrDefault(cur, new ArrayList<>())) {
      if (visited.contains(v)) {
        continue;
      }
      dfs(g, v, stack, visited);
    }
    stack.push(cur);
  }

  private static Map<Integer, List<Integer>> reverseGraph(final int[][] edges) {
    final Map<Integer, List<Integer>> result = new HashMap<>();
    final int n = edges.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (edges[i][j] == 1) {
          result.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
        }
      }
    }
    return result;
  }

  private Map<Integer, List<Integer>> getGraph(final int[][] edges) {
    final Map<Integer, List<Integer>> result = new HashMap<>();
    final int n = edges.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (edges[i][j] == 1) {
          result.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
        }
      }
    }
    return result;
  }
}
