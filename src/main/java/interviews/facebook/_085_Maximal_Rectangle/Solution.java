package interviews.facebook._085_Maximal_Rectangle;

import java.util.Arrays;

public class Solution {

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[] left = new int[cols], right = new int[cols], heights = new int[cols];
    Arrays.fill(right, cols - 1);
    int maxArea = 0;
    for (int row = 0; row < rows; row++) {
      int curLeft = 0, curRight = cols - 1;

      // update height
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          heights[col]++;
        } else {
          heights[col] = 0;
        }
      }

      // update left
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          left[col] = Math.max(left[col], curLeft);
        } else {
          left[col] = 0;
          curLeft = col + 1;
        }
      }

      // update right
      for (int col = cols - 1; col >= 0; col--) {
        if (matrix[row][col] == '1') {
          right[col] = Math.min(right[col], curRight);
        } else {
          right[col] = cols;
          curRight = col - 1;
        }
      }

      // update the max
      for (int col = 0; col < cols; col++) {
        maxArea = Math.max(maxArea, (right[col] - left[col] + 1) * heights[col]);
      }
    }

    return maxArea;
  }
}
