package _0901_0950._931_Minimum_Falling_Path_Sum;

import java.util.Arrays;

/**
 * @author zhixi
 * @version 1.0 on 9/21/2020
 */
public final class SolutionI implements Solution {
  private static final int[] COLS = {-1, 0, 1};

  public int minFallingPathSum(int[][] A) {
    final int rows = A.length, cols = A[0].length;
    int[] prevRow = new int[cols];
    System.arraycopy(A[0], 0, prevRow, 0, cols);
    for (int i = 1; i < rows; ++i) {
      final int[] curRow = new int[cols];
      Arrays.fill(curRow, Integer.MAX_VALUE);
      for (int col = 0; col < cols; ++col) {
        for (int d : COLS) {
          final int nextCol = col + d;
          if (nextCol < 0 || nextCol >= cols) continue;
          curRow[nextCol] = Math.min(curRow[nextCol], prevRow[col] + A[i][nextCol]);
        }
      }
      prevRow = curRow;
    }
    int min = prevRow[0];
    for (int i = 1; i < cols; ++i) {
      min = Math.min(min, prevRow[i]);
    }
    return min;
  }
}
