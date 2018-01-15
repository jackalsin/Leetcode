package interviews.google._296_Best_Meeting_Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class Solution {

  public int minTotalDistance(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    final List<Integer> rowIndex = new ArrayList<>();
    final List<Integer> colIndex = new ArrayList<>();

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          rowIndex.add(row);
          colIndex.add(col);
        }
      }
    }
    Collections.sort(colIndex);
    int midRow = rowIndex.get(rowIndex.size() / 2);
    int midCol = colIndex.get(colIndex.size() / 2);
    return getDistance(rowIndex, midRow) + getDistance(colIndex, midCol);
  }

  private static int getDistance(List<Integer> points, int midCol) {
    int res = 0;
    for (int i : points) {
      res += Math.abs(i - midCol);
    }

    return res;
  }
}
