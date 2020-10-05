package linkedin._547_Friend_Circles;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
public final class UnionFindSolutionII implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }
    final int n = M.length;
    final UnionFind uf = new UnionFind(n);
    for (int i = 0; i < M.length; ++i) {
      for (int j = i + 1; j < M.length; ++j) {
        if (M[i][j] == 1) {
          uf.union(i, j);
        }
      }
    }
    return uf.individualCounts;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;
    private int individualCounts;

    private UnionFind(final int n) {
      individualCounts = n;
      roots = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
      sizes = new int[n];
      Arrays.fill(sizes, 1);
    }

    public void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
      individualCounts--;
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
