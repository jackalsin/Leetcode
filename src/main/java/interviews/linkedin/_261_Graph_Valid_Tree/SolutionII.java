package interviews.linkedin._261_Graph_Valid_Tree;

import java.util.Arrays;

public final class SolutionII implements Solution {
  public boolean validTree(int n, int[][] edges) {
    // G has no simple cycles and has n − 1 edges.
    if (edges.length != n - 1) {
      return false;
    }
    int rootCount = n;
    final UnionFind uf = new UnionFind(n);
    for (final int[] e : edges) {
      final int p = e[0], q = e[1];
      if (uf.root(p) != uf.root(q)) {
        uf.union(p, q);
        rootCount--;
      }
    }
    return rootCount == 1;
  }

  private static final class UnionFind {
    private final int n;
    private final int[] roots, size;

    private UnionFind(int n) {
      this.n = n;
      roots = new int[n];
      size = new int[n];
      Arrays.fill(size, 1);
      for (int i = 0; i < n; i++) {
        roots[i] = i;
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
        roots[p] = roots[roots[p]];
      }
      return p;
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = size[rootP], sizeQ = size[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        size[rootQ] += size[rootP];
      } else {
        roots[rootQ] = rootP;
        size[rootP] += size[rootQ];
      }
    }
  }
}
