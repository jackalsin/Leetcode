package linkedin._547_Friend_Circles;

import java.util.Arrays;

public final class UnionFindSolutionI implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    if (M == null) {
      throw new NullPointerException();
    }
    final int n = M.length;
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (M[i][j] == 1) {
          uf.union(i, j);
        }
      }
    }
    return uf.individualRoot;
  }

  private static final class UnionFind {
    private final int[] roots, size;
    private int individualRoot;

    private UnionFind(final int n) {
      roots = new int[n];
      for (int i = 0; i < n; i++) {
        roots[i] = i;
      }
      size = new int[n];
      Arrays.fill(size, 1);
      individualRoot = n;
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = size[rootP], sizeQ = size[rootQ];
      if (rootP == rootQ) {
        return;
      }
      individualRoot--;
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        size[rootQ] += size[rootP];
      } else {
        roots[rootQ] = rootP;
        size[rootP] += size[rootQ];
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
