package _0701_0750._750_Number_Of_Corner_Rectangles;

import java.util.HashMap;
import java.util.Map;

public final class SolutionII implements Solution {
  private static final int MAX_COLS = 200; // col [1, 199]

  public int countCornerRectangles(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int cols = grid[0].length;
    int count = 0;
    final Map<Integer, Integer> colPairToCount = new HashMap<>();
    for (final int[] row : grid) {
      for (int i = 0; i < cols; i++) {
        if (row[i] == 0) continue;
        for (int j = i + 1; j < cols; j++) {
          if (row[j] == 0) continue;

          final int pos = MAX_COLS * i + j;
          final int curCount = colPairToCount.getOrDefault(pos, 0);
          count += curCount;
          colPairToCount.put(pos, curCount + 1);
        }
      }
    }

    return count;
  }
}
