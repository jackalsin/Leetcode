package _1401_1450._1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/3/2020
 */
public final class ONSolution implements Solution {
  @Override
  public int longestSubarray(int[] nums, int limit) {
    final Deque<Integer> minDeque = new ArrayDeque<>(),
        maxDeque = new ArrayDeque<>();
    int left = 0, result = 0;
    for (int i = 0; i < nums.length; ++i) {
      while (!minDeque.isEmpty() && minDeque.peekLast() > nums[i]) {
        minDeque.removeLast();
      }
      minDeque.addLast(nums[i]);
      while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[i]) {
        maxDeque.removeLast();
      }
      maxDeque.addLast(nums[i]);
      while (!minDeque.isEmpty() && !maxDeque.isEmpty() && Math.abs(maxDeque.peekFirst() - minDeque.peekFirst()) > limit) {
        if (minDeque.peekFirst() == nums[left]) minDeque.removeFirst();
        if (maxDeque.peekFirst() == nums[left]) maxDeque.removeFirst();
        ++left;
      }
      result = Math.max(result, i - left + 1);
    }
    return result;
  }
}
