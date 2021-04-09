package lime._085_Maximal_Rectangle;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/8/2021
 */
public final class DpSolution implements Solution {
  private static final char ONE = '1', ZERO = '0';

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int n = matrix[0].length;
    final int[] left = new int[n], // 以heights[i]为最低的left
        right = new int[n], // 以heights[i]为最低的right
        heights = new int[n];
    Arrays.fill(right, n - 1);
    int maxArea = 0;
    for (final char[] row : matrix) {
      for (int i = 0; i < n; ++i) {
        if (row[i] == ONE) heights[i]++;
        else heights[i] = 0;
      }
      int curLeft = 0, // curLeft是连续1的起点（从左）
          curRight = n; // curRight是连续1的起点（从右）
      // 为啥这个是对的:
      // 1. 如果row[i]是1，那么只有两种可能
      //    1. 从之前继承的，比如最上层是的left是2，那么至少得从2开始
      //    1. 楼层中间断过，那么现在可能得从3或者4开始了
      for (int i = 0; i < n; ++i) {
        if (row[i] == ONE) left[i] = Math.max(curLeft, left[i]);
        else {
          curLeft = i + 1;
          left[i] = 0;
        }
      }
      for (int i = n - 1; i >= 0; --i) {
        if (row[i] == ONE) right[i] = Math.min(curRight, right[i]);
        else {
          curRight = i - 1;
          right[i] = n - 1;
        }
      }
      for (int i = 0; i < n; ++i) {
        final int area = (right[i] - left[i] + 1) * heights[i];
        maxArea = Math.max(maxArea, area);
      }
    } // end of for row

    return maxArea;
  }
}
