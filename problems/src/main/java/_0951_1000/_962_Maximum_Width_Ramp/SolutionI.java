package _0951_1000._962_Maximum_Width_Ramp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxWidthRamp(int[] A) {
    if (A == null) {
      return 0;
    }
    final int n = A.length;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (stack.isEmpty() || A[stack.peek()] > A[i]) {
        stack.push(i);
      }
    }
    int max = 0;
    for (int i = n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
        max = Math.max(max, i - stack.pop());
      }
    }
    return max;
  }
}
