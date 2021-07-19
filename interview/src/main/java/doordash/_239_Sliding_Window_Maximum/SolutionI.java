package doordash._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionI implements Solution {
  /**
   * TODO:
   */
  @Override
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k > nums.length || k < 1) return new int[]{};
    final Deque<Integer> stack = new ArrayDeque<>();
    final int n = nums.length;
    final int[] res = new int[n - k + 1];
    for (int i = 0; i < n; ++i) {
      if (i - k + 1 >= 0 && !stack.isEmpty() && stack.peekFirst() < i - k + 1) {
        stack.removeFirst();
      }
      while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
        stack.removeLast();
      }
      stack.addLast(i);
      if (i - k + 1 >= 0) {
        res[i - k + 1] = nums[stack.peekFirst()];
      }
    }
    return res;
  }
}
