package interviews.linkedin._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.Arrays;

public class Solution {
  public int countComponents(int n, int[][] edges) {
    final int[] roots = new int[n + 1], sizes = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      roots[i] = i;
    }
    Arrays.fill(sizes, 1);
    sizes[0] = 0;
    int count = n;
    for (final int[] edge : edges) {
      final int p = edge[0], q = edge[1];
      if (root(roots, p) != root(roots, q)) {
        count--;
        union(roots, sizes, p, q);
      }
    }

    return count;
  }

  private void union(int[] roots, int[] sizes, int p, int q) {
    final int rootP = root(roots, p), rootQ = root(roots, q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
    if (sizeP < sizeQ) {
      roots[rootP] = roots[rootQ];
      sizes[rootQ] += sizes[rootP];
    } else {
      roots[rootQ] = roots[rootP];
      sizes[rootP] += sizes[rootQ];
    }
  }

  private int root(int[] roots, int p) {
    while (p != roots[p]) {
      roots[p] = roots[roots[p]];
      p = roots[p];
    }
    return p;
  }
}
