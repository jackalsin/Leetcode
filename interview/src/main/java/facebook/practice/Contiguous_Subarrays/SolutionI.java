package facebook.practice.Contiguous_Subarrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] countSubarrays(int[] arr) {
    if (arr == null || arr.length == 0) return arr;
    final int n = arr.length;
    final Deque<Integer> stack = new ArrayDeque<>();
    final int[] rights = new int[n],
        lefts = new int[n],
        result = new int[n];
    for (int i = 0; i < n; ++i) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        stack.pop();
      }
      lefts[i] = (stack.isEmpty() ? -1 : stack.peek()) + 1;
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        stack.pop();
      }
      rights[i] = (stack.isEmpty() ? n : stack.peek()) - 1;
      result[i] = rights[i] - lefts[i] + 1;
      stack.push(i);
    }
    return result;
  }
}
