package google._684_Redundant_Connection;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public final class Solution {

  public int[] findRedundantConnection(int[][] edges) {
    int n = 0;
    for (final int[] edge : edges) {
      n = Math.max(edge[1], n);
    }

    final int[] roots = new int[n + 1], size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      roots[i] = i;
    }
    Arrays.fill(size, 1);
    for (final int[] edge : edges) {
      int rootP = root(roots, edge[0]), rootQ = root(roots, edge[1]);
      if (rootP == rootQ) {
        return edge;
      }
      if (size[rootP] > size[rootQ]) {
        roots[rootQ] = rootP;
        size[rootP] += size[rootQ];
      } else {
        roots[rootP] = rootQ;
        size[rootQ] += size[rootP];
      }
    }
    throw new IllegalStateException("Could not find the redundant edge");
  }

  private static int root(final int[] roots, int i) {
    while (roots[i] != i) {
      roots[i] = roots[roots[i]];
      i = roots[i];
    }
    return i;
  }
}
