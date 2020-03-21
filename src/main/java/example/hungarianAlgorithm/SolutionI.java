package example.hungarianAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 3/16/2020
 */
public final class SolutionI implements Solution {
  /**
   * Reference:
   * https://www.renfei.org/blog/bipartite-matching.html
   * https://blog.csdn.net/jvruo233/article/details/81390672
   *
   * @param n     size of vertex
   * @param edges unweighted undirected edge, id starts from 0
   * @return
   */
  @Override
  public List<Integer> match(int n, int[][] edges) {
    final int[] secondaryParents = new int[n],
        matches = new int[n],
        check = new int[n];
    Arrays.fill(secondaryParents, -1);
    Arrays.fill(matches, -1);
    final Map<Integer, List<Integer>> adjacentLists = getAdjacentLists(edges);
    for (int i = 0; i < n; ++i) {
      if (matches[i] == -1) { // not matched
        final Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        boolean hasFoundAugmentPath = false;
        while (!q.isEmpty() && !hasFoundAugmentPath) {
          final int u = q.remove();
          final List<Integer> neighbors = adjacentLists.getOrDefault(u, new ArrayList<>());
          for (int j = 0; j < neighbors.size() && !hasFoundAugmentPath; j++) {
            final int v = neighbors.get(j);
            if (check[v] != i) {
              check[v] = i;
              if (matches[v] == -1) { // 非匹配点
                hasFoundAugmentPath = true;
                int d = u, e = v;
                while (d != -1) {
                  final int nextE = matches[d];
                  matches[e] = d;
                  matches[d] = e;
                  d = secondaryParents[d];
                  e = nextE;
                }
              } else { // 匹配点
                q.add(matches[v]);
                secondaryParents[matches[v]] = u;
              }
            }

          }
        }
      }
    }
    return Arrays.stream(matches).boxed().collect(Collectors.toList());
  }

  private Map<Integer, List<Integer>> getAdjacentLists(final int[][] edges) {
    final Map<Integer, List<Integer>> result = new HashMap<>();
    for (final int[] e : edges) {
      result.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
      result.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
    }
    return result;
  }
}
