package _1651_1700._1673_Find_the_Most_Competitive_Subsequence;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2020
 */
public final class MonoDecreasingStackSolution implements Solution {
  @Override
  public int[] mostCompetitive(int[] nums, int k) {
    final int n = nums.length;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + n - i > k) {
        stack.pop();
      }
      if (stack.size() < k) {
        stack.push(nums[i]);
      }
    }
    final int[] result = new int[k];
    for (int i = k - 1; i >= 0; --i) {
      result[i] = stack.pop();
    }
    return result;
  }
}
