package lime._261_Graph_Valid_Tree;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class SolutionI implements Solution {

  public boolean validTree(int n, int[][] edges) {
    final UnionFind uf = new UnionFind(n);
    for (final int[] edge : edges) {
      final int p = edge[0], q = edge[1],
          rootP = uf.root(p), rootQ = uf.root(q);
      if (rootP == rootQ) {
        return false;
      }
      uf.union(rootP, rootQ);
    }
    return n - 1 == edges.length;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;

    private UnionFind(final int n) {
      roots = new int[n];
      sizes = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
      Arrays.fill(sizes, 1);
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }
  }
}
