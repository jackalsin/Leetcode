package _651_700._684_Redundant_Connection;

import java.util.Arrays;

public class Solution {
  /* Valid range is from 1 to roots.length - 1 */
  private int[] roots;
  private int[] size;
  private int[] res = null;

  /**
   * In this problem, a tree is an undirected graph that is connected and has no cycles.
   * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
   * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that
   * represents an undirected edge connecting nodes u and v.
   * <p>
   * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple
   * answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
   *
   * @param edges
   * @return
   */
  public int[] findRedundantConnection(int[][] edges) {
    // key idea: using the union find to find the groups that forms a cycle, return the last one that occurs in the
    // edges.
    int maxVertexNum = 0;
    for (final int[] edge : edges) {
      maxVertexNum = Math.max(maxVertexNum, edge[1]);
    }
    roots = new int[maxVertexNum + 1];
    for (int i = 1; i < maxVertexNum + 1; i++) {
      roots[i] = i;
    }
    size = new int[maxVertexNum + 1];
    Arrays.fill(size, 1, maxVertexNum + 1, 1);

    for (final int[] edge : edges) {
      union(edge[0], edge[1]);
    }
    return res;
  }

  private void union(int p, int q) {
    final int rootP = root(p), rootQ = root(q), sizeP = size[p], sizeQ = size[q];
    if (rootP != rootQ) {
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        size[q] += sizeP;
      } else {
        roots[rootQ] = rootP;
        size[p] += sizeQ;
      }
    } else {
      res = new int[]{p, q};
    }
  }

  private int root(int v) {
    while (roots[v] != v) {
      v = roots[v];
    }
    return v;
  }

}
