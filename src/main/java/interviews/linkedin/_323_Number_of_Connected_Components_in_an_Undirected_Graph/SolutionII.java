package interviews.linkedin._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/10/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int countComponents(int n, int[][] edges) {
    if (edges == null) {
      return n;
    }
    final UnionFind uf = new UnionFind(n);
    for (final int[] e : edges) {
      uf.union(e[0], e[1]);
    }
    return uf.individualRoots;
  }

  private static final class UnionFind {
    private final int[] roots, size;
    private int individualRoots;

    private UnionFind(int n) {
      individualRoots = n;
      roots = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        roots[i] = i;
      }
      Arrays.fill(size, 1);
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q);
      if (rootP == rootQ) return;
      --individualRoots;
      if (size[rootP] > size[rootQ]) {
        size[rootP] += size[rootQ];
        roots[rootQ] = rootP;
      } else {
        size[rootQ] += size[rootP];
        roots[rootP] = rootQ;
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
