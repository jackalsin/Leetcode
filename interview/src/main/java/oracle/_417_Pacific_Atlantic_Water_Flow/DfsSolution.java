package oracle._417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2019
 */
public final class DfsSolution implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    final List<List<Integer>> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final boolean[][] pacific = new boolean[rows][cols],
        atlantic = new boolean[rows][cols];
    for (int row = 0; row < rows; ++row) {
      pacific[row][0] = true;
      dfs(matrix, pacific, row, 0);
      atlantic[row][cols - 1] = true;
      dfs(matrix, atlantic, row, cols - 1);
    }
    for (int col = 0; col < cols; ++col) {
      pacific[0][col] = true;
      dfs(matrix, pacific, 0, col);
      atlantic[rows - 1][col] = true;
      dfs(matrix, atlantic, rows - 1, col);
    }
//    display(pacific);
//    display(atlantic);
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }
    return result;
  }

  private static void dfs(final int[][] matrix, final boolean[][] visited, final int row, final int col) {
    visited[row][col] = true;
    final int curHeight = matrix[row][col], rows = matrix.length, cols = matrix[0].length;
    for (final int[] dir : DIRS) {
      final int nextRow = dir[0] + row, nextCol = dir[1] + col;
      if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || visited[nextRow][nextCol] || curHeight > matrix[nextRow][nextCol]) {
        continue;
      }
      dfs(matrix, visited, nextRow, nextCol);
    }
  }
}
