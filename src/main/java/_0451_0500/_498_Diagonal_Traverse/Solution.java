package _0451_0500._498_Diagonal_Traverse;

public class Solution {
  private static final int[][] DIRS = {{-1, 1}, {1, -1}};

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[] result = new int[rows * cols];
    int idx = 0, row = 0, col = 0, dirIdx = 0;
    while (idx < result.length) {
      result[idx++] = matrix[row][col];
      row += DIRS[dirIdx][0];
      col += DIRS[dirIdx][1];

      if (row < 0 || col < 0 || row >= rows || col >= cols) {
        if (row >= rows) {
          row = rows - 1;
          col += 2;
        }
        if (col >= cols) {
          col = cols - 1;
          row += 2;
        }
        if (row < 0) {
          row = 0;
        }
        if (col < 0) {
          col = 0;
        }
        dirIdx = (dirIdx + 1) % 2;
      }

    }
    return result;
  }
}
