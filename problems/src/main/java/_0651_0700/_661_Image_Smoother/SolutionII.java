package _0651_0700._661_Image_Smoother;

/**
 * @author jacka
 * @version 1.0 on 3/9/2020
 */
public final class SolutionII implements Solution {
  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 0}, {0, 1},
      {1, -1}, {1, 0}, {1, 1}
  };

  public int[][] imageSmoother(int[][] M) {
    if (M == null || M.length == 0) {
      return M;
    }
    final int rows = M.length, cols = M[0].length;
    final int[][] result = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        result[row][col] = getAvg(M, row, col);
      }
    }
    return result;
  }

  private static int getAvg(final int[][] m, final int row, final int col) {
    final int rows = m.length, cols = m[0].length;
    int sum = 0, count = 0;
    for (final int[] d : DIRS) {
      final int nextRow = row + d[0], nextCol = col + d[1];
      if (isValid(rows, cols, nextRow, nextCol)) {
        sum += m[nextRow][nextCol];
        count++;
      }
    }
    return sum / count;
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
