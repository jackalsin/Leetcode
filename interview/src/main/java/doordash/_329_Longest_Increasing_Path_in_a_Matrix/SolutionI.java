package doordash._329_Longest_Increasing_Path_in_a_Matrix;

public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}
  };

  public int longestIncreasingPath(int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] distances = new int[rows][cols];
    int max = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (distances[row][col] != 0) continue;
        int cur = dfs(distances, matrix, rows, cols, row, col);
        max = Math.max(max, cur);
      }
    }
    return max;
  }

  private static int dfs(final int[][] distances, final int[][] matrix, final int rows,
                         final int cols, final int row, final int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols) return 0;
    if (distances[row][col] != 0) return distances[row][col];
    int max = 1;
    for (final int[] d : DIRS) {
      final int nextRow = row + d[0], nextCol = col + d[1];
      if (nextRow < 0 || nextCol < 0 || nextCol >= cols || nextRow >= rows) continue;
      if (matrix[nextRow][nextCol] <= matrix[row][col]) continue;
      final int cur = dfs(distances, matrix, rows, cols, nextRow, nextCol);
      max = Math.max(max, 1 + cur);
    }
    distances[row][col] = max;
    return max;
  }
}
