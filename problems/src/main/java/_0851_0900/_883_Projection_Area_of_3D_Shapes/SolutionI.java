package _0851_0900._883_Projection_Area_of_3D_Shapes;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int projectionArea(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int m = grid.length, n = grid[0].length;
    final int[] rows = new int[m],
        cols = new int[n];
    int sum = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        rows[i] = Math.max(rows[i], grid[i][j]);
        cols[j] = Math.max(cols[j], grid[i][j]);
        if (grid[i][j] > 0) sum++;
      }
    }
    for (int r : rows) {
      sum += r;
    }
    for (int c : cols) {
      sum += c;
    }
    return sum;
  }
}
