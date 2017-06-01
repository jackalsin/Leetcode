package _051_100._085_Maximal_Rectangle;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/21/2017.
 */
public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[] left = new int[cols]; //以现在的高度，左边界
    int[] right = new int[cols];
    int[] height = new int[cols];
    int maxArea = 0;
    Arrays.fill(right, cols);
    for (int row = 0; row < rows; row++) {
      int curLeft = 0, curRight = cols;
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          height[col]++;
        } else {
          height[col] = 0;
        }
      }
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          left[col] = Math.max(curLeft, left[col]);
        } else {
          left[col] = 0; curLeft = col + 1;
        }
      }

      for (int col = cols - 1; col>= 0; col--) {
        if (matrix[row][col] == '1') {
          right[col] = Math.min(right[col], curRight);
        } else {
          right[col] = cols; curRight = col;
        }
      }

      for (int col = 0; col < cols; col++) {
        maxArea = Math.max(maxArea, (right[col] - left[col]) * height[col]);
      }
    }
    return maxArea;
  }
}
