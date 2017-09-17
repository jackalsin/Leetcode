package _301_350._310_Minimum_Height_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/16/2017.
 */
public class Solution {
  /**
   * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n
   * and a list of undirected edges (each edge is a pair of labels).
   *
   * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
   * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
   * @param n
   * @param edges
   * @return
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return Collections.singletonList(0);
    Map<Integer, Set<Integer>> pointsToPoints = new HashMap<>();
    for (int i = 0; i < n; ++i) pointsToPoints.putIfAbsent(i, new HashSet<>());
    for (int[] edge : edges) {
      pointsToPoints.get(edge[0]).add(edge[1]);
      pointsToPoints.get(edge[1]).add(edge[0]);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (pointsToPoints.get(i).size() == 1) {
        leaves.add(i);
      }
    }

    while (n > 2) {
      n -= leaves.size();
      List<Integer> newLeaves = new ArrayList<>();
      for(int leaf : leaves) {
        int connected = pointsToPoints.get(leaf).iterator().next();
        Set<Integer> connectedSet = pointsToPoints.get(connected);
        connectedSet.remove(leaf);
        if (connectedSet.size() == 1) {
          newLeaves.add(connected);
        }
      }
      leaves = newLeaves;
    }

    return leaves;
  }
}
