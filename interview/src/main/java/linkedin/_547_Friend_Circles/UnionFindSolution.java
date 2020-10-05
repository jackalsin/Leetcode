package linkedin._547_Friend_Circles;

import java.util.Arrays;

public final class UnionFindSolution implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    assert 1 <= M.length && M.length <= 2000;
    final int N = M.length;
    final UnionFind uf = new UnionFind(N);
    int count = N;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; ++j) {
        if (M[i][j] == 1) {
          final int rootP = uf.root(i), rootQ = uf.root(j);
          if (rootP != rootQ) {
            M[i][j] = 0;
            M[j][i] = 0;
            uf.union(rootP, rootQ);
            count--;
          }
        }
      }
    }
    assert count == uf.count;
    return count;
  }

  private static final class UnionFind {
    private final int n;
    private final int[] roots, size;
    private int count;

    private UnionFind(int n) {
      this.n = n;
      this.count = n;
      this.roots = new int[n];
      this.size = new int[n];
      Arrays.fill(size, 1);
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
    }

    public void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = size[rootP], sizeQ = size[rootQ];
      assert rootP != rootQ;
      if (sizeP >= sizeQ) {
        size[rootP] += sizeQ;
        roots[rootQ] = rootP;
      } else {
        size[rootQ] += sizeP;
        roots[rootP] = rootQ;
      }
      count--;
    }

    public int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
        roots[p] = roots[roots[p]];
      }
      return p;
    }
  }


}
