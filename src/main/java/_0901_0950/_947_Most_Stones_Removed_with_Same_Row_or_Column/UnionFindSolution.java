package _0901_0950._947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.HashMap;
import java.util.Map;

public final class UnionFindSolution implements Solution {
  private final Map<Integer, Integer> parents = new HashMap<>();
  private int islands = 0;

  public int removeStones(int[][] stones) {
    for (final int[] stone : stones) {
      final int row = stone[0], col = ~stone[1];
      if (parents.putIfAbsent(row, row) == null) islands++;
      if (parents.putIfAbsent(col, col) == null) islands++;
      union(row, col);
    }
    return stones.length - islands;
  }

  private void union(final int r, final int c) {
    final int rootX = root(r), rootY = root(c);
    if (rootX != rootY) {
      islands--;
      parents.put(rootX, rootY);
    }
  }

  private int root(int p) {
    while (p != parents.get(p)) {
      parents.put(parents.get(p), parents.get(parents.get(p)));
      p = parents.get(p);
    }
    return p;
  }
}
