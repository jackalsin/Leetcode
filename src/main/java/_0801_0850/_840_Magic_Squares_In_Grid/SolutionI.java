package _0801_0850._840_Magic_Squares_In_Grid;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2020
 */
public final class SolutionI implements Solution {
  //  {
//    {4, 3, 8},
//    {9, 5, 1},
//    {2, 7, 6}
//  }
  private static final List<Integer> ITERATE = List.of(0, 1, 2, 5, 8, 7, 6, 3),
      ALL = List.of(4, 3, 8, 1, 6, 7, 2, 9);

  /**
   * Drived from <a href='https://leetcode.com/problems/magic-squares-in-grid/discuss/133874/Python-5-and-43816729'></a>
   */
  public int numMagicSquaresInside(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int count = 0;
    final int rows = grid.length, cols = grid[0].length;
    for (int i = 1; i < rows - 1; ++i) {
      for (int j = 1; j < cols - 1; ++j) {
        if (isValid(grid, i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private static boolean isValid(final int[][] grid, final int x, final int y) {
    if (grid[x][y] != 5) return false;
    if (isInOrder(grid, x - 1, y - 1, 1) || isInOrder(grid, x - 1, y - 1, -1)) {
      return true;
    }
    return false;
  }

  /**
   * {x, y} is the left top corner
   */
  private static boolean isInOrder(final int[][] grid, final int x, final int y, final int d) {
    int startIndex = ALL.indexOf(grid[x][y]);
    if (startIndex == -1) return false;
    for (int i : ITERATE) {
      if (grid[x + i / 3][y + i % 3] != ALL.get(startIndex)) {
        return false;
      }
      startIndex = (startIndex + d + 8) % 8;
    }
    return true;
  }
}
