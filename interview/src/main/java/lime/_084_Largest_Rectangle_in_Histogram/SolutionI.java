package lime._084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/8/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    final int n = heights.length;
    final int[] lessThanInLeft = new int[n],
        lessThanInRight = new int[n];
    Arrays.fill(lessThanInLeft, -1);
    Arrays.fill(lessThanInRight, n);
    int max = 0;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        lessThanInLeft[i] = stack.peek();
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        lessThanInRight[i] = stack.peek();
      }
      stack.push(i);
    }
    for (int i = 0; i < n; ++i) {
      final int area = heights[i] * (lessThanInRight[i] - lessThanInLeft[i] - 1);
      max = Math.max(area, max);
    }
    return max;
  }
}
