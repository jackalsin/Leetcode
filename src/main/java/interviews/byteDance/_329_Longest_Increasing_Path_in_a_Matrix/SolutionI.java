package interviews.byteDance._329_Longest_Increasing_Path_in_a_Matrix;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int max = 0;
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] maxToHere = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        maxToHere[row][col] = dfs(maxToHere, matrix, rows, cols, row, col);
        max = Math.max(max, maxToHere[row][col]);
      }
    }
    return max;
  }

  private static int dfs(final int[][] maxToHere, final int[][] matrix, final int rows, final int cols,
                         final int row, final int col) {
    if (maxToHere[row][col] != 0) {
      return maxToHere[row][col];
    }
    int cur = 1;
    for (final int[] d : DIRS) {
      final int nextRow = row + d[0], nextCol = col + d[1];
      if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || matrix[row][col] <= matrix[nextRow][nextCol])
        continue;
      cur = Math.max(cur, 1 + dfs(maxToHere, matrix, rows, cols, nextRow, nextCol));
    }
    maxToHere[row][col] = cur;
    return maxToHere[row][col];
  }
}
