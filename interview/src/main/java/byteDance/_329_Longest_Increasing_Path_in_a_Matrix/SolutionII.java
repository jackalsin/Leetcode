package byteDance._329_Longest_Increasing_Path_in_a_Matrix;

/**
 * @author jacka
 * @version 1.0 on 3/30/2021
 */
public final class SolutionII implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };
  private static final int PREV = -1;
  private int rows = 0, cols = 0;
  private int[][] cache;

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    rows = matrix.length;
    cols = matrix[0].length;
    cache = new int[rows][cols];
    int max = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        final int res = longestIncreasingPath(matrix, i, j, PREV);
        max = Math.max(max, res);
      }
    }
    return max;
  }

  private int longestIncreasingPath(final int[][] matrix, final int row, final int col, final int prev) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] <= prev) {
      return 0;
    }
    if (cache[row][col] != 0) {
      return cache[row][col];
    }
    final int curVal = matrix[row][col];
    matrix[row][col] = PREV;
    int res = 1;
    for (final int[] dir : DIRS) {
      final int cur = longestIncreasingPath(matrix, row + dir[0], col + dir[1], curVal);
      res = Math.max(res, 1 + cur);
    }
    matrix[row][col] = curVal;
    cache[row][col] = res;
    return res;
  }
}
