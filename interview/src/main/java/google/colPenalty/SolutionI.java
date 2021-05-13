package google.colPenalty;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/12/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int maxScore(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;
    final int rows = matrix.length, cols = matrix[0].length;
    int[] dp = new int[cols];
    System.arraycopy(matrix[0], 0, dp, 0, cols);
    for (int row = 1; row < rows; ++row) {
      final int[] next = new int[cols];
      Arrays.fill(next, Integer.MAX_VALUE);
      for (int col = 0; col < cols; ++col) {
        for (int prevCol = 0; prevCol < cols; ++prevCol) {
          next[col] = Math.min(next[col], dp[prevCol] + matrix[row][col] + Math.abs(col - prevCol));
        }
      }
      dp = next;
    }
    assert dp.length != 0;
    return Arrays.stream(dp).max().getAsInt();
  }
}
