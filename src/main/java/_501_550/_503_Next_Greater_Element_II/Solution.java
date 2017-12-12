package _501_550._503_Next_Greater_Element_II;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

  public int[] nextGreaterElements(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    final int n = nums.length;
    final int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < 2 * n; i++) {
      int num = nums[i % n];
      while (!stack.isEmpty() && nums[stack.peek()] < num) {
        result[stack.pop()] = num;
      }
      if (i < n) {
        stack.push(i);
      }
    }
    return result;
  }
}
