package doordash._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionII implements Solution {
  @Override
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0 || k > nums.length) return new int[0];
    final int n = nums.length;
    final int[] res = new int[n - k + 1];
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      // remove head
      if (i >= k && !stack.isEmpty() && stack.peekFirst() == i - k) {
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
