package _351_400._361_Bomb_Enemy;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class Solution {
  /**
   * The Time Complexity is O(MN), the inner for loop should only calculated once.
   * @param grid
   * @return
   */
  public int maxKilledEnemies(char[][] grid) {
    if( grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    final int rows = grid.length, cols = grid[0].length;
    final int[] colHits = new int[cols];
    int result = 0;
    for (int row = 0; row < rows; row++) {
      int rowHits = 0;
      for (int col = 0; col < cols; col++) {
        if (col == 0 || grid[row][col - 1] == 'W') {
          // pre cal
          rowHits = 0;
          for (int k = col; k < cols && grid[row][k] != 'W'; k++) {
            rowHits += grid[row][k] == 'E' ? 1 : 0;
          }
        }
        if (row == 0 || grid[row - 1][col] == 'W') {
          colHits[col] = 0;
          for (int k = row; k < rows && grid[k][col] != 'W'; k++) {
            colHits[col] += grid[k][col] == 'E' ? 1 : 0;
          }
        }

        if (grid[row][col] == '0' ) {
          result = Math.max(result, rowHits + colHits[col]);
        }

      }
    }
    return result;
  }

}
