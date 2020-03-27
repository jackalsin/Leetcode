package interviews.google._947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public final class SolutionI implements Solution {
  private static final int MAX_ROW = 10_000;

  public int removeStones(int[][] stones) {
    if (stones == null || stones.length == 0) {
      return 0;
    }
    final int n = stones.length;
    final Map<Integer, List<Integer>> grouped = new HashMap<>();
    for (int i = 0, stonesLength = stones.length; i < stonesLength; i++) {
      final int[] s = stones[i];
      grouped.computeIfAbsent(s[0], k -> new ArrayList<>()).add(i);
      grouped.computeIfAbsent(s[1] + MAX_ROW, k -> new ArrayList<>()).add(i);
    }
    final UnionFind uf = new UnionFind(n);
    for (final Map.Entry<Integer, List<Integer>> g : grouped.entrySet()) {
      final List<Integer> index = g.getValue();
      for (int i = 0; i < index.size() - 1; ++i) {
        uf.union(index.get(i), index.get(i + 1));
      }
    }
    return n - uf.individualRoots;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;
    private final int n;
    private int individualRoots;

    private UnionFind(int n) {
      this.n = n;
      individualRoots = n;
      roots = new int[n];
      sizes = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
      Arrays.fill(sizes, 1);
    }

    public void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
      individualRoots--;
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
      }
      return p;
    }
  }
}
