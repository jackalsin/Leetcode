package lime._085_Maximal_Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/8/2021
 */
public final class MonoStackSolution implements Solution {
  private static final char ONE = '1';

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int n = matrix[0].length;
    final int[] heights = new int[n],
        left = new int[n],
        right = new int[n];
    int maxArea = 0;
    for (final char[] row : matrix) {
      for (int i = 0; i < n; ++i) {
        heights[i] = row[i] == ONE ? heights[i] + 1 : 0;
      }
      final Deque<Integer> stack = new ArrayDeque<>();
      for (int i = 0; i < n; ++i) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
          stack.pop();
        }
        left[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
      }
      stack.clear();
      for (int i = n - 1; i >= 0; --i) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
          stack.pop();
        }
        right[i] = stack.isEmpty() ? n : stack.peek();
        stack.push(i);
      }
      for (int i = 0; i < n; ++i) {
        final int width = right[i] - left[i] - 1,
            area = width * heights[i];
        maxArea = Math.max(area, maxArea);
      }
    }
    return maxArea;
  }
}
