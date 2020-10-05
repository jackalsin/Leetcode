package linkedin._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int countComponents(int n, int[][] edges) {
    final UnionFind uf = new UnionFind(n);
    for (final int[] e : edges) {
      final int p = e[0], q = e[1],
          rootP = uf.root(p), rootQ = uf.root(q);
      if (rootP == rootQ) continue;
      uf.union(rootP, rootQ);
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
      Arrays.fill(sizes, 1);
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
      individualRoots--;
    }
  }
}
