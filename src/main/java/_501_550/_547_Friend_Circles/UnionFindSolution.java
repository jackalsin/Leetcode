package _501_550._547_Friend_Circles;

import java.util.Arrays;

public final class UnionFindSolution implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    final int n = M.length;
    final UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (M[i][j] == 1 && (uf.root(i) != uf.root(j))) {
          M[i][j] = 0;
          M[j][i] = 0;
          uf.union(i, j);
        }
      }
    }
    return uf.count;
  }

  private static final class UnionFind {
    private final int n;
    private final int[] roots, size;
    private int count;

    public UnionFind(int n) {
      this.n = n;
      roots = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        roots[i] = i;
      }
      Arrays.fill(size, 1);
      count = n;
    }

    private int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
        roots[p] = roots[roots[p]];
      }
      return p;
    }

    private void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = size[rootP], sizeQ = size[rootQ];
      if (rootP == rootQ) return;
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        size[rootQ] += size[rootP];
      } else {
        roots[rootQ] = rootP;
        size[rootP] += size[rootQ];
      }
      count--;
    }
  }
}
