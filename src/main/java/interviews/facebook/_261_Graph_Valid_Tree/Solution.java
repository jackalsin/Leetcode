package interviews.facebook._261_Graph_Valid_Tree;

public class Solution {
  /**
   * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function
   * to check whether these edges make up a valid tree.
   *
   * @param n
   * @param edges
   * @return
   */
  public boolean validTree(int n, int[][] edges) {
    final int[] roots = new int[n];
    for (int i = 0; i < n; i++) {
      roots[i] = i;
    }

    for (final int[] edge : edges) {

      final int rootP = root(roots, edge[0]),
          rootQ = root(roots, edge[1]);
      if (rootP == rootQ) {
        return false;
      }
      union(roots, rootQ, rootP);
    }

    return edges.length == n - 1;
  }

  private int root(int[] roots, int p) {
    while (p != roots[p]) {
      roots[p] = roots[roots[p]];
      p = roots[p]; // path compression

    }
    return p;
  }

  private void union(final int[] roots, final int rootQ, final int rootP) {
    roots[rootP] = rootQ;
  }
}
