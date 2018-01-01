package _651_700._685_Redundant_Connection_II;

import java.util.Arrays;

public class Solution {

  /**
   * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which
   * all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node
   * which has no parents.
   * <p>
   * Several things need to be pointed out:
   * Cycle doesn't have directions.
   * <p>
   * https://discuss.leetcode.com/topic/105108/c-java-union-find-with-explanation-o-n/2
   *
   * @param edges
   * @return
   */
  public int[] findRedundantDirectedConnection(int[][] edges) {
//    1) Check whether there is a node having two parents.
//        If so, store them as candidates A and B, and set the second edge invalid.
//    2) Perform normal union find.
//    If the tree is now valid
//        simply return candidate B
//    else if candidates not existing
//        we find a circle, return current edge;
//    else
//        remove candidate A instead of B.
    int[] candidate1 = new int[]{-1, -1};
    int[] candidate2 = new int[]{-1, -1};
    final int[] roots = new int[edges.length + 1];
    for (final int[] edge : edges) {
      if (roots[edge[1]] == 0) {
        roots[edge[1]] = edge[0];
      } else {
        candidate1 = new int[]{roots[edge[1]], edge[1]};
        candidate2 = new int[]{edge[0], edge[1]};
        edge[1] = 0; // making candidate2 invalid.
      }
    }

    for (int i = 1; i < edges.length + 1; i++) {
      roots[i] = i;
    }

    for (final int[] edge : edges) {
      if (edge[1] == 0) continue;
      int p = edge[0], q = edge[1], rootP = root(roots, p);
      if (q == rootP) {
        // no nodes have 2 parents, 自己从头到尾形成cycle
        if (Arrays.equals(candidate1, new int[]{-1, -1})) {
          return edge;
        }
        return candidate1;
      } else {
        roots[q] = rootP;
      }
    }

    return candidate2;
  }

  private static int root(final int[] roots, int k) {
    while (roots[k] != k) {
      roots[k] = roots[roots[k]];
      k = roots[k];
    }
    return k;
  }

}
