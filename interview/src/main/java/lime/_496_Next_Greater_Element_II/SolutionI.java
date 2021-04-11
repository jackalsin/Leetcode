package lime._496_Next_Greater_Element_II;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/11/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    final Deque<Integer> stack = new ArrayDeque<>();
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    final int[] result = new int[nums1.length];
    for (int i = nums2.length - 1; i >= 0; --i) {
      while (!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]) {
        stack.pop();
      }
      valToIndex.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
      stack.push(i);
    }
    for (int i = 0; i < nums1.length; ++i) {
      result[i] = valToIndex.getOrDefault(nums1[i], -1);
    }
    return result;
  }
}
