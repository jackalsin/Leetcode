package linkedin._261_Graph_Valid_Tree;

/**
 * @author jacka
 * @version 1.0 on 7/29/2019
 */
public final class UnionFindSolutionI implements Solution {
  @Override
  public boolean validTree(int n, int[][] edges) {
    if (n <= 0 || edges == null) {
      return false;
    }
    final int[] parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
    int individualRoots = n;
    for (final int[] e : edges) {
      final int rootP = root(parents, e[0]), rootQ = root(parents, e[1]);
      if (rootP == rootQ) {
        return false;
      } else {
        union(parents, rootP, rootQ);
        individualRoots--;
      }
    }
    return individualRoots == 1;
  }

  private static void union(final int[] parents, final int rootP, final int rootQ) {
    parents[rootP] = rootQ;
  }

  private static int root(final int[] parents, int p) {
    while (p != parents[p]) {
      p = parents[p];
    }
    return p;
  }
}
