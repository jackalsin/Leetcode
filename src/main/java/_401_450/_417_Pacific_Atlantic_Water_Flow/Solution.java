package _401_450._417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public List<int[]> pacificAtlantic(int[][] matrix) {
    final List<int[]> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] visited = new int[rows][cols];

    for (int col = 0; col < cols; col++) {
      visited[0][col] |= 1; visited[rows - 1][col] |= 2;
      dfs(matrix, visited, rows, cols, 0, col, 1); // top
      dfs(matrix, visited, rows, cols, rows - 1, col, 2); // bottom
    }
    for (int row = 0; row < rows; row++) {
      visited[row][0] |= 1; visited[row][cols - 1] |= 2;
      dfs(matrix, visited, rows, cols, row, 0, 1); // left
      dfs(matrix, visited, rows, cols, row, cols - 1, 2); // right
    }

    return getResult(visited, 3);
  }

  private void dfs(final int[][] matrix, final int[][] visited, final int rows, final int cols, final int startRow,
                   final int startCol, final int visitBit) {
    final int curHeight = matrix[startRow][startCol];
    for (final int[] dir: DIRS) {
      int nextRow = startRow + dir[0], nextCol = startCol + dir[1];
      if (nextCol >= 0 && nextRow >= 0 && nextCol < cols && nextRow < rows &&
          (visited[nextRow][nextCol] & visitBit) != visitBit && matrix[nextRow][nextCol] >= curHeight) {
        visited[nextRow][nextCol] |= visitBit;
        dfs(matrix, visited, rows, cols, nextRow, nextCol, visitBit);
      }
    }
  }

  private static List<int[]> getResult(final int[][] visited, final int target) {
    final List<int[]> result = new ArrayList<>();
    final int rows = visited.length, cols = visited[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (target == visited[row][col]) {
          result.add(new int[]{row, col});
        }
      }
    }
    return result;
  }
}
