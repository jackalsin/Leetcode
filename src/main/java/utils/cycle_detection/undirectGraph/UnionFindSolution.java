package utils.cycle_detection.undirectGraph;

/**
 * @author jacka
 * @version 1.0 on 7/13/2019
 */
public final class UnionFindSolution implements Solution {
  @Override
  public boolean hasCycle(int n, int[][] edges) {
    final int[] roots = new int[n];
    for (int i = 0; i < n; i++) {
      roots[i] = i;
    }
    for (final int[] e : edges) {
      final int rootP = root(roots, e[0]), rootQ = root(roots, e[1]);
      if (rootP == rootQ) {
        return true;
      }
      roots[rootP] = rootQ;
    }
    return false;
  }

  private int root(final int[] roots, int p) {
    while (roots[p] != p) {
      roots[p] = roots[roots[p]];
      p = roots[p];
    }
    return p;
  }

}
