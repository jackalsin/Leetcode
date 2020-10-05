package hulu._1063_Number_of_Valid_Subarrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/28/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int validSubarrays(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final Deque<Integer> stack = new ArrayDeque<>();
    int count = 0;
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() > num) {
        stack.pop();
      }
      stack.push(num);
      count += stack.size();
//      System.out.println("stack = " + stack + ", count = " + count);
    }
    return count;
  }
}
