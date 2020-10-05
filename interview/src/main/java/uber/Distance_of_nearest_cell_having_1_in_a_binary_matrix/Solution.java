package uber.Distance_of_nearest_cell_having_1_in_a_binary_matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public final class Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  /**
   * Given a binary matrix of N x M, containing at least a value 1. The task is to find the distance of nearest 1 in
   * the matrix for each cell. The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number
   * and column number of the current cell and i2, j2 are the row number and column number of the nearest cell having
   * value 1.
   *
   * @param matrix a 2d matrix array that only contains <tt>1</tt> and <tt>0</tt>
   * @return the manhattan distance to the nearest 1
   */
  public long[][] findMinDistance(final int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new long[0][];
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final long[][] res = new long[rows][cols];
    final Queue<int[]> q = new ArrayDeque<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == 1) {
          q.add(new int[]{row, col});
        }
      }
    }
    long distance = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int[] toRemove = q.remove();
        final int row = toRemove[0], col = toRemove[1];
        res[row][col] = distance;
        for (final int[] d : DIRS) {
          final int nextRow = row + d[0], nextCol = col + d[1];
          if (isValid(rows, cols, nextRow, nextCol) && matrix[nextRow][nextCol] != 1) {
            matrix[nextRow][nextCol] = 1;
            q.add(new int[]{nextRow, nextCol});
          }
        }
      }
      distance++;
    }

    return res;
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
