package _251_300._296_Best_Meeting_Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/9/2017.
 */
public class Solution {
  /**
   * As long as there is equal number of points to the left and right of the meeting point, the total distance is minimized.
   * @param grid
   * @return
   */
  public int minTotalDistance(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    List<Integer> rowIndex = new ArrayList<>();
    List<Integer> colIndex = new ArrayList<>();
    for (int row =  0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
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

  private int getDistance(List<Integer> points, int point) {
    int dis = 0;
    for(int child: points) {
      dis += Math.abs(point - child);
    }
    return dis;
  }
}
