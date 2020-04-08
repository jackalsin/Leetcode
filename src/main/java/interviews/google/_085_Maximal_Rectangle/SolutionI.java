package interviews.google._085_Maximal_Rectangle;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
public final class SolutionI implements Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[] height = new int[cols],
        left = new int[cols], // 以height[i]为高，往左最远能够延申到的点
        right = new int[cols];
    Arrays.fill(right, cols - 1);
    int max = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (matrix[row][col] == '1') {
          height[col]++;
        } else {
          height[col] = 0;
        }
      }
      int prevLeft = 0;
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          left[col] = Math.max(left[col], prevLeft);
        } else {
          prevLeft = col + 1;
          left[col] = 0; // set to initial value
        }
      }
      int prevRight = cols - 1;
      for (int col = cols - 1; col >= 0; col--) {
        if (matrix[row][col] == '1') {
          right[col] = Math.min(right[col], prevRight);
        } else {
          prevRight = col - 1;
          right[col] = cols - 1; // set to initial value
        }
      }

      for (int col = 0; col < cols; ++col) {
        final int cur = (right[col] - left[col] + 1) * height[col];
        max = Math.max(cur, max);
      }
    }
    return max;
  }
}
