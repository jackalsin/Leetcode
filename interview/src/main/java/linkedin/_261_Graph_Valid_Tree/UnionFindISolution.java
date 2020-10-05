package linkedin._261_Graph_Valid_Tree;

public final class UnionFindISolution implements Solution {
  public boolean validTree(int n, int[][] edges) {
    // G has no simple cycles and has n − 1 edges.
    if (edges.length != n - 1) {
      return false;
    }
    int roots = n;
    final UnionFind uf = new UnionFind(n);
    for (final int[] edge : edges) {
      final int p = edge[0], q = edge[1];
      if (uf.root(p) != uf.root(q)) {
        uf.union(p, q);
        roots--;
      }
    }
    return roots == 1;
  }

  private static final class UnionFind {
    private final int[] roots;

    UnionFind(int n) {
      roots = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        roots[i] = i;
      }
    }

    int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
      }
      return p;
    }

    void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q);
      roots[rootP] = rootQ;
    }
  }
}
