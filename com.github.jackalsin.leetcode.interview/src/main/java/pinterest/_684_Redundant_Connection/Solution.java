package pinterest._684_Redundant_Connection;

public class Solution {
  private static final int MAX_EDGES = 1000;

  public int[] findRedundantConnection(int[][] edges) {
    final UnionFind uf = new UnionFind(edges.length + 1);
    for (final int[] edge : edges) {
      final int p = edge[0], q = edge[1], rootP = uf.root(p), rootQ = uf.root(q);
      if (rootP == rootQ) {
        return edge;
      }
      uf.union(rootP, rootQ);
    }
    throw new IllegalStateException("Cannot find a redundant edge");
  }


  private static final class UnionFind {
    private final int[] roots, sizes;

    UnionFind(final int size) {
      roots = new int[size];
      sizes = new int[size];
      for (int i = 1; i < size; i++) {
        roots[i] = i;
        sizes[i] = i;
      }
//      Arrays.fill(size, 1);
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
      if (sizeP > sizeQ) {
        roots[rootQ] = rootP;
        sizes[rootQ] += rootP;
      } else {
        roots[rootP] = rootQ;
        sizes[rootP] += rootQ;
      }
    }

    private int root(int p) {
      while (roots[p] != p) {
        // path compression
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }

  }
}
