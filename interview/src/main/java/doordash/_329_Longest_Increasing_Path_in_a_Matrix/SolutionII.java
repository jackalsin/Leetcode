package doordash._329_Longest_Increasing_Path_in_a_Matrix;

public final class SolutionII implements Solution {
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;
    final int rows = matrix.length, cols = matrix[0].length;
    int max = 0;
    final int[][] cache = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        int dist = dfs(matrix, cache, rows, cols, row, col);
        max = Math.max(dist, max);
      }
    }
    return max;
  }

  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  private static int dfs(final int[][] matrix, final int[][] cache, final int rows, final int cols,
                         final int row, final int col) {
    if (cache[row][col] != 0) return cache[row][col];
    int dist = 1;
    for (final int[] d : DIRS) {
      final int nextRow = row + d[0], nextCol = col + d[1];
      if (!isInRange(rows, cols, nextRow, nextCol) || matrix[row][col] <= matrix[nextRow][nextCol]) continue;
      dist = Math.max(dist, dfs(matrix, cache, rows, cols, nextRow, nextCol) + 1);
    }
    cache[row][col] = dist;
    return dist;
  }

  private static boolean isInRange(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
