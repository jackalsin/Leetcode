package interviews.google._329_Longest_Increasing_Path_in_a_Matrix;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] maxToHere = new int[rows][cols];
    int max = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        final int cur = dfs(matrix, maxToHere, i, j);
        maxToHere[i][j] = cur;
        max = Math.max(max, cur);
      }
    }
    return max;
  }

  private static int dfs(final int[][] matrix, final int[][] maxToHere, final int i, final int j) {
    final int rows = matrix.length, cols = matrix[0].length;
    if (maxToHere[i][j] != 0) {
      return maxToHere[i][j];
    }
    int max = 1;
    for (final int[] d : DIRS) {
      final int nextRow = d[0] + i, nextCol = d[1] + j;
      if (isInRange(rows, cols, nextRow, nextCol) && matrix[nextRow][nextCol] < matrix[i][j]) {
        max = Math.max(max, dfs(matrix, maxToHere, nextRow, nextCol) + 1);
      }
    }
    maxToHere[i][j] = max;
    return max;
  }

  private static boolean isInRange(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
