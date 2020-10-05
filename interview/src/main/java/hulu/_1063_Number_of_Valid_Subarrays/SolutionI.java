package hulu._1063_Number_of_Valid_Subarrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int validSubarrays(int[] nums) {
    //f element i is the smallest one we encountered so far, it does not form any valid subarray with previous
    // elements. Otherwise, it forms a valid subarray starting from each previous element that is smaller.
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = 0;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() > num) {
        stack.pop();
      }
      stack.push(num);
      sum += stack.size();
    }
    return sum;
  }
}
