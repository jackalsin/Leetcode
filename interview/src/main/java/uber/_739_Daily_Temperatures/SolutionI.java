package uber._739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/17/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) return temperatures;
    final int size = temperatures.length;
    final int[] result = new int[size];
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = size - 1; i >= 0; --i) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        stack.pop();
      }
      result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return result;
  }
}
