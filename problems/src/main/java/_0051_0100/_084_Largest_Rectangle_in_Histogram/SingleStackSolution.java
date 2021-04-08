package _0051_0100._084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/20/2017.
 */
public final class SingleStackSolution implements Solution {
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    final Deque<Integer> stack = new ArrayDeque<>();
    final int len = heights.length;
    int maxArea = 0;
    for (int i = 0; i < len; ++i) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        final int toRemove = stack.pop(), h = heights[toRemove],
            width = i - (stack.isEmpty() ? -1 : stack.peek()) - 1,
            area = h * width; // 计算以h为最低的最大面积，如果出现多次，将被计算多次
        maxArea = Math.max(maxArea, area);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      final int toRemove = stack.pop(), h = heights[toRemove],
          width = len - (stack.isEmpty() ? -1 : stack.peek()) - 1;
      maxArea = Math.max(maxArea, h * width);
    }
    return maxArea;
  }
}
