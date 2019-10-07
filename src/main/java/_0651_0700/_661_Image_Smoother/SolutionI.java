package _0651_0700._661_Image_Smoother;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 0}, {0, 1},
      {1, -1}, {1, 0}, {1, 1},
  };

  public int[][] imageSmoother(int[][] M) {
    if (M == null || M.length == 0) {
      return M;
    }
    final int rows = M.length, cols = M[0].length;
    final int[][] result = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        result[row][col] = average(M, row, col);
      }
    }
    return result;
  }

  private static int average(final int[][] m, final int row, final int col) {
    final int rows = m.length, cols = m[0].length;
    int count = 0, sum = 0;
    for (final int[] d : DIRS) {
      if (isValid(rows, cols, row + d[0], col + d[1])) {
        count++;
        sum += m[row + d[0]][col + d[1]];
      }
    }
    return count == 0 ? 0 : sum / count;
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return row >= 0 && col >= 0 && row < rows && col < cols;
  }
}
