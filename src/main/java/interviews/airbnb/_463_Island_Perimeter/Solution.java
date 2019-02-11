package interviews.airbnb._463_Island_Perimeter;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public class Solution {
  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int island = 0, neighbors = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          island++;
          if (col + 1 < cols && grid[row][col + 1] == 1) {
            neighbors++;
          }
          if (row + 1 < rows && grid[row + 1][col] == 1) {
            neighbors++;
          }
        }
      }
    }
    return (int) (island * 4L - neighbors * 2L);
  }
}
