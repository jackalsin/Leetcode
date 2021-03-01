package apple._305_Number_of_Islands_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {-1, 0}, {1, 0},
  };

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    final List<Integer> result = new ArrayList<>();
    final int[] roots = new int[m * n];
    Arrays.fill(roots, -1);
    int individualRoot = 0;
    for (final int[] p : positions) {
      final int index = p[0] * n + p[1];
      if (roots[index] == -1) {
        roots[index] = index;
        ++individualRoot;
        for (final int[] d : DIRS) {
          final int x = p[0] + d[0], y = p[1] + d[1];
          if (x < 0 || y < 0 || x >= m || y >= n) continue;
          final int otherKey = x * n + y;
          if (roots[otherKey] == -1) continue;
          final int rootP = root(roots, index),
              rootQ = root(roots, otherKey);
          if (rootP == rootQ) continue;
          --individualRoot;
          roots[rootP] = rootQ;
        }
      }
      result.add(individualRoot);
    }
    return result;
  }

  private static int root(final int[] roots, int p) {
    while (p != roots[p]) {
      roots[p] = roots[roots[p]];
      p = roots[p];
    }
    return p;
  }

}
