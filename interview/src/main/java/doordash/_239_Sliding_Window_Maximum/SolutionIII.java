package doordash._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionIII implements Solution {
  @Override
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) return nums;
    final int n = nums.length;
    final int[] result = new int[n - k + 1];
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0, j = 0; i < n; ++i, ++j) {
      if (i >= k && i - k == stack.peekFirst()) {
        stack.removeFirst();
      }
      while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
        stack.removeLast();
      }
      stack.addLast(i);
      if (j - k + 1 >= 0) result[j - k + 1] = nums[stack.peekFirst()];
    }
    return result;
  }
}
