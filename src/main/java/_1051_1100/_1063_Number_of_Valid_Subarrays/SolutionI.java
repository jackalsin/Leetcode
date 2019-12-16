package _1051_1100._1063_Number_of_Valid_Subarrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 12/15/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int validSubarrays(int[] nums) {
    int sum = 0;
    if (nums == null || nums.length == 0) {
      return sum;
    }
    final int n = nums.length;
    final Deque<int[]> stack = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && stack.peek()[0] >= nums[i]) {
        stack.pop();
      }
      sum += stack.isEmpty() ? n - i : stack.peek()[1] - i;
      stack.push(new int[]{nums[i], i});
    }
    return sum;
  }
}
