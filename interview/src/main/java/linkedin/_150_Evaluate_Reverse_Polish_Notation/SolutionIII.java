package linkedin._150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/28/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }
    final Deque<Integer> stack = new ArrayDeque<>();
    for (final String token : tokens) {
      if ("+".equals(token)) {
        stack.push(stack.pop() + stack.pop());
      } else if ("-".equals(token)) {
        stack.push(-stack.pop() + stack.pop());
      } else if ("*".equals(token)) {
        stack.push(stack.pop() * stack.pop());
      } else if ("/".equals(token)) {
        final int div = stack.pop();
        stack.push(stack.pop() / div);
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.isEmpty() ? 0 : stack.pop();
  }
}