package linkedin._261_Graph_Valid_Tree;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/1/2019
 */
public final class UnionFindSolutionII implements Solution {
  @Override
  public boolean validTree(int n, int[][] edges) {
    if (n <= 0 || edges == null) {
      return false;
    }
    if (edges.length != n - 1) {
      return false;
    }
    final UnionFind uf = new UnionFind(n);
    for (final int[] e : edges) {
      final int rootP = uf.root(e[0]), rootQ = uf.root(e[1]);
      if (rootP == rootQ) return false;
      uf.union(rootP, rootQ);
    }
    return uf.individualRoots == 1;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;
    private int individualRoots;

    private UnionFind(int n) {
      individualRoots = n;
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
      assert rootP != rootQ;
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
      individualRoots--;
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
