package interviews.linkedin._946_Validate_Stack_Sequences;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    if (pushed == null || popped == null) {
      return false;
    }
    final Deque<Integer> stack = new ArrayDeque<>();
    int j = 0;
    for (int val : pushed) {
      stack.push(val);
      while (!stack.isEmpty() && stack.peek() == popped[j]) {
        stack.pop();
        j++;
      }
    }
    return j == popped.length;
  }
}
