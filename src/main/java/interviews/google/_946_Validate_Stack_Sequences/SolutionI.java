package interviews.google._946_Validate_Stack_Sequences;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int pushIndex = 0, popIndex = 0;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (; pushIndex < pushed.length && popIndex < popped.length; ) {
      stack.push(pushed[pushIndex++]);
      while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
        stack.pop();
        popIndex++;
      }
    }
    return popIndex == pushed.length && pushIndex == popped.length && stack.isEmpty();
  }
}
