package _0301_0350._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class Solution {
  private int[] roots;
  private int[] size;
  private int count;

  public int countComponents(int n, int[][] edges) {
    roots = new int[n];
    size = new int[n];
    count = n;
    Arrays.fill(size, 1);
    for (int i = 0; i < n; ++i) roots[i] = i;

    for(int[] edge: edges) {
      int p = edge[0], q = edge[1];
      int rootP = root(p), rootQ = root(q);
      if (rootP == rootQ) continue;
      if (size[rootP] > size[rootQ]) {
        roots[rootP] = roots[rootQ];
        size[rootQ] += size[rootP];
      } else {
        roots[rootQ] = roots[rootP];
        size[rootP] += size[rootQ];
      }
      count--;
    }

    return count;
  }

  private int root(int p) {
    while (roots[p] != p) {
      roots[p] = roots[roots[p]]; // with path compression 3 ms, without 14 ms
      p = roots[p];
    }
    return p;
  }

}
