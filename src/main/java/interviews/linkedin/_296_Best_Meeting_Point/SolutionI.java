package interviews.linkedin._296_Best_Meeting_Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    final List<Integer> colUsed = new ArrayList<>(),
        rowUsed = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          rowUsed.add(row);
        }
      }
    }
    for (int col = 0; col < cols; col++) {
      for (int row = 0; row < rows; row++) {
        if (grid[row][col] == 1) {
          colUsed.add(col);
        }
      }
    }

    return getMin(rowUsed) + getMin(colUsed);
  }

  private static int getMin(final List<Integer> index) {
    int res = 0;
    for (int i = 0, j = index.size() - 1; i < j; i++, j--) {
      res += index.get(j) - index.get(i);
    }
    return res;
  }
}
