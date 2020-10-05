package byteDance._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0) {
      return nums;
    }
    final int n = nums.length;
    final int[] res = new int[n - k + 1];
    final Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (i >= k && nums[i - k] == q.peekFirst()) {
        q.removeFirst();
      }
      while (!q.isEmpty() && q.peekLast() < nums[i]) {
        q.removeLast();
      }
      q.addLast(nums[i]);
      if (i - k + 1 >= 0) {
        res[i - k + 1] = q.peekFirst();
      }
    }
    return res;
  }
}
