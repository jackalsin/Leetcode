package _1051_1100._1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    int res = 0;
    final Set<Integer> visited = new HashSet<>();
    for (int row = 0; row < rows; ++row) {
      int count = 0;
      final int[] flip = getFlip(matrix[row]);
      for (int i = 0; i < rows; i++) {
        final int[] curRow = matrix[i];
        if (!visited.contains(i) && Arrays.equals(curRow, matrix[row]) || Arrays.equals(curRow, flip)) {
          visited.add(i);
          count++;
        }
      }
      res = Math.max(res, count);
    }
    return res;
  }

  private static int[] getFlip(final int[] matrix) {
    final int n = matrix.length;
    final int[] result = new int[n];
    for (int i = 0; i < n; ++i) {
      result[i] = 1 - matrix[i];
    }
    return result;
  }
}
