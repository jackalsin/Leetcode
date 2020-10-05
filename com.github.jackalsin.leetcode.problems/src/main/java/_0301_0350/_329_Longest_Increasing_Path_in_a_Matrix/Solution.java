package _0301_0350._329_Longest_Increasing_Path_in_a_Matrix;

/**
 * Runtime: 14 ms
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 9/29/2017.
 */
public class Solution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] cache = new int[rows][cols];
    int max = 1;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        int cur = dfs(matrix, cache, rows, cols, row, col);
        max = Math.max(max, cur);
      }
    }
    return max;
  }

  private int dfs(final int[][] matrix, final int[][] cache,
                  final int rows, final int cols, int row, int col) {
    if (cache[row][col] != 0) return cache[row][col];
    int max = 1;
    for (int[] dir : DIRS) {
      int nextRow = dir[0] + row, nextCol = dir[1] + col;
      if (0 <= nextCol && nextCol < cols && 0 <= nextRow && nextRow < rows
          && matrix[nextRow][nextCol] > matrix[row][col]) { // Use matrix[x][y] <= matrix[i][j] so we don't need a
        // visited[m][n] array
        max = Math.max(max, 1 + dfs(matrix, cache, rows, cols, nextRow, nextCol));
      }
    }
    cache[row][col] = max;
    return max;
  }
}
