package _0201_0250._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/3/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1) {
      return new int[0];
    }
    final int n = nums.length;
    final int[] result = new int[n - k + 1];
    final Deque<Integer> candidates = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (i - k >= 0 && !candidates.isEmpty() && candidates.peekFirst() == nums[i - k]) {
        candidates.removeFirst();
      }
      // 有多个保留多个
      while (!candidates.isEmpty() && candidates.peekLast() < nums[i]) {
        candidates.removeLast();
      }
      candidates.addLast(nums[i]);
      assert !candidates.isEmpty();
      if (i - k + 1 >= 0) {
        result[i - k + 1] = candidates.peekFirst();
      }
    }
    return result;
  }
}
