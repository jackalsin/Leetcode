package linkedin._547_Friend_Circles;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/11/2019
 */
public final class UnionFindSolutionIII implements Solution {

  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }
    final int rows = M.length, cols = M[0].length;
    UnionFind uf = new UnionFind(rows);
    for (int row = 0; row < rows; ++row) {
      for (int col = row + 1; col < cols; ++col) {
        if (M[row][col] == 1) {
          uf.union(row, col);
        }
      }
    }
    return uf.individualRoots;
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
      final int rootP = root(p), rootQ = root(q);
      if (rootP == rootQ) return;
      final int sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
      --individualRoots;
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
