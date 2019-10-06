package interviews.pureStorage._0150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class SolutionI implements Solution {
  private static final String PLUS = "+", MINUS = "-", MULTI = "*", DIVIDE = "/";

  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }
    final Deque<Long> stack = new ArrayDeque<>();
    for (final String token : tokens) {
      if (token.equals(PLUS)) {
        stack.push((long) stack.pop() + stack.pop());
      } else if (MINUS.equals(token)) {
        stack.push(-((long) (stack.pop())) + stack.pop());
      } else if (MULTI.equals(token)) {
        stack.push((long) stack.pop() * stack.pop());
      } else if (DIVIDE.equals(token)) {
        final long p2 = stack.pop(), p1 = stack.pop();
        stack.push(p1 / p2);
      } else {
        stack.push(Long.parseLong(token));
      }
    }
    assert stack.size() == 1;
    return Math.toIntExact(stack.pop());
  }
}
