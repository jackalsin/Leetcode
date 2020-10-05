package linkedin._739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[] dailyTemperatures(int[] T) {
    if (T == null) {
      return null;
    }
    final int[] res = new int[T.length];
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = T.length - 1; i >= 0; --i) {
      while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
        stack.pop();
      }
      res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return res;
  }
}
