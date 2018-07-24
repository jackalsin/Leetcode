package _701_750._750_Number_Of_Corner_Rectangles;

public final class SolutionI implements Solution {

  /**
   * Time Complexity: O(R * C * C)
   * Space Complexity: O(R * C)
   *
   * @param grid
   * @return
   */
  public int countCornerRectangles(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int cols = grid[0].length;
    int count = 0;
    final int[][] dp = new int[cols][cols];
    for (final int[] row : grid) {
      for (int i = 0; i < cols; i++) {
        if (row[i] == 0) continue;
        for (int j = i + 1; j < cols; j++) {
          if (row[j] == 0) continue;
          final int curCount = dp[i][j];
          count += curCount;
          dp[i][j]++;
        }
      }
    }

    return count;
  }
}
