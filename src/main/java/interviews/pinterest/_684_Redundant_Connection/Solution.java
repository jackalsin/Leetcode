package interviews.pinterest._684_Redundant_Connection;

import java.util.Arrays;

public class Solution {
  private static final int MAX_EDGES = 1000;

  public int[] findRedundantConnection(int[][] edges) {
    final UnionFind uf = new UnionFind();
    for (final int[] edge : edges) {

    }
    return null;
  }


  private static final class UnionFind {
    private static final int SIZE = 2 * MAX_EDGES + 1;
    private final int[] roots = new int[SIZE], size = new int[SIZE];

    UnionFind() {
      for (int i = 1; i < SIZE; i++) {
        roots[i] = i;
      }
      Arrays.fill(size, 1);
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = size[rootP], sizeQ = size[rootQ];

    }

    private int root(int p) {
      while (roots[p] != p) {
        // path compression
        p = roots[p];
      }
      return p;
    }

  }
}
