package linkedin._296_Best_Meeting_Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/2/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    final List<Integer> allRows = new ArrayList<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          allRows.add(row);
        }
      }
    }

    final List<Integer> allCols = new ArrayList<>();
    for (int col = 0; col < cols; ++col) {
      for (int row = 0; row < rows; ++row) {
        if (grid[row][col] == 1) {
          allCols.add(col);
        }
      }
    }
    return getDistance(allCols) + getDistance(allRows);
  }

  private static int getDistance(final List<Integer> cols) {
    int res = 0;
    for (int i = 0, j = cols.size() - 1; i < j; ++i, --j) {
      res += cols.get(j) - cols.get(i);
    }
    return res;
  }
}
