package dynamicProgramming._085_Maximal_Rectangle;

import java.util.Arrays;

public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int maxArea = 0;
    final int height[] = new int[cols], left[] = new int[cols], right[] = new int[cols];
    Arrays.fill(right, cols - 1);
    for (int row = 0; row < rows; row++) {
      // find height
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          height[col]++;
        } else {
          height[col] = 0;
        }
      }

      // find left
      {
        int l = 0;
        for (int col = 0; col < cols; col++) {
          if (matrix[row][col] == '1') {
            left[col] = Math.max(left[col], l);
          } else {
            left[col] = 0;
            l = col + 1;
          }
        }
      }
      // find right
      {
        int r = cols - 1;
        for (int col = cols - 1; col >= 0; col--) {
          if (matrix[row][col] == '1') {
            right[col] = Math.min(right[col], r);
          } else {
            right[col] = cols - 1;
            r = col - 1;
          }
        }
      }
      // find max
      for (int col = 0; col < cols; col++) {
        maxArea = Math.max(maxArea, (right[col] - left[col] + 1) * height[col]);
      }
    }
    return maxArea;
  }

}
