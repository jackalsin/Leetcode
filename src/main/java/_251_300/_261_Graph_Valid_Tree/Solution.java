package _251_300._261_Graph_Valid_Tree;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class Solution {
  public boolean validTree(int n, int[][] edges) {
    final int[] roots = new int[n];
    Arrays.fill(roots, -1);
    for (int[] edge: edges) {
      int x = find(roots, edge[0]);
      int y = find(roots, edge[1]);

      if (x == y) return false;
      roots[x] = y;
      System.out.println(Arrays.toString(roots));

    }
    return n - 1 == edges.length; // to avoid test2Components case
  }

  private int find(int[] roots, int i) {
    if (roots[i] == -1) return i;
    else return find(roots, roots[i]);
  }

}
