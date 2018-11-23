package _0151_0200._200_Number_of_Islands;

/**
 * @author jacka
 * @version 1.0 on 8/4/2017.
 */
public class Solution {
  /**
   * Not using a visited board:
   * <p>
   * 47 / 47 test cases passed.
   * Status: Accepted
   * Runtime: 6 ms
   * <p>
   * Using a board
   * <p>
   * 47 / 47 test cases passed.
   * Status: Accepted
   * Runtime: 15 ms
   *
   * @param grid
   * @return
   */
  public int numIslands(char[][] grid) {
    int rows = grid.length;
    if (rows == 0) {
      return 0;
    }
    int cols = grid[0].length;
    if (cols == 0) {
      return 0;
    }
    int count = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == '1') {
          dfsUpdate(grid, row, col, rows, cols);
          count++;
        }
      }
    }
    return count;
  }

  private void dfsUpdate(char[][] grid, int row, int col, final int rows, final int cols) {
    if (row < 0 || col < 0 || col >= cols || row >= rows || grid[row][col] != '1') return;
    grid[row][col] = '0';
    dfsUpdate(grid, row - 1, col, rows, cols);
    dfsUpdate(grid, row, col - 1, rows, cols);
    dfsUpdate(grid, row + 1, col, rows, cols);
    dfsUpdate(grid, row, col + 1, rows, cols);
  }
}
