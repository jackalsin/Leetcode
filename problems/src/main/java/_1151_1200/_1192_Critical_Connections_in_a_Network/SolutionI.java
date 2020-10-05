package _1151_1200._1192_Critical_Connections_in_a_Network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class SolutionI implements Solution {
  private static final int UNVISITED = -2;
  private final Map<Integer, List<Integer>> adjacentList = new HashMap<>();
  private int index = 0;
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    for (int i = 0; i < n; ++i) {
      adjacentList.put(i, new ArrayList<>());
    }

    for (final List<Integer> e : connections) {
      final int p = e.get(0), q = e.get(1);
      adjacentList.get(p).add(q);
      adjacentList.get(q).add(p);
    }

    final int[] label = new int[n], low = new int[n];
    Arrays.fill(label, UNVISITED);
    Arrays.fill(low, UNVISITED);

    dfs(label, low, 0, -1);

//    System.out.println(adjacentList);
//    System.out.println(Arrays.toString(label));
//    System.out.println(Arrays.toString(low));
    for (final List<Integer> e : connections) {
      final int p = e.get(0), q = e.get(1);
      if (label[p] < low[q] || label[q] < low[p]) {
        result.add(e);
      }
    }
    return result;
  }

  private void dfs(final int[] label, final int[] low, final int cur, final int parent) {
    assert label[cur] == UNVISITED;
    label[cur] = index++;
    low[cur] = label[cur];
    for (final int child : adjacentList.get(cur)) {
      if (label[child] == UNVISITED) {
        dfs(label, low, child, cur);
      }
      if (child != parent) {
        low[cur] = Math.min(low[cur], low[child]);
      }
    }
  }
}
