package _0051_0100._084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/6/2021
 */
public final class DpSolution implements Solution {
  @Override
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    final int n = heights.length;
    final int[] lessInLeft = new int[n],
        lessInRight = new int[n];
    Arrays.fill(lessInLeft, -1);
    Arrays.fill(lessInRight, n);
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        lessInLeft[i] = stack.peek();
      }
      stack.push(i);
    }

    stack.clear();
    for (int i = n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        lessInRight[i] = stack.peek();
      }
      stack.push(i);
    }
//    System.out.println(Arrays.toString(lessInLeft));
//    System.out.println(Arrays.toString(lessInRight));
    int max = 0;
    for (int i = 0; i < n; ++i) {
      final int cur = heights[i] * ((lessInRight[i] - 1) - (lessInLeft[i] + 1) + 1);
      max = Math.max(max, cur);
    }
    return max;
  }
}
