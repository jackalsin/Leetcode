package _0501_0550._542_01_Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public final class BfsSolution implements Solution {
  private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return matrix;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final Queue<int[]> queue = new ArrayDeque<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == 0) {
          queue.add(new int[]{row, col});
        } else {
          matrix[row][col] = Integer.MAX_VALUE;
        }
      }
    }
    while (!queue.isEmpty()) {
      final int[] start = queue.remove();
      for (final int[] dir : DIRS) {
        final int curRow = start[0] + dir[0], curCol = start[1] + dir[1];
        if (curRow < 0 || curCol < 0 || curCol >= cols || curRow >= rows
            || matrix[curRow][curCol] != Integer.MAX_VALUE) continue;
        matrix[curRow][curCol] = matrix[start[0]][start[1]] + 1;
        queue.add(new int[]{curRow, curCol});
      }
    }
    return matrix;
  }
}
