package linkedin._150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionIV implements Solution {
  private static final String PLUS = "+",
      MINUS = "-", MULTI = "*", DIVIDE = "/";

  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) return 0;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (final String token : tokens) {
      if (PLUS.equals(token)) {
        final int op2 = stack.pop(), op1 = stack.pop();
        stack.push(op1 + op2);
      } else if (MINUS.equals(token)) {
        final int op2 = stack.pop(), op1 = stack.pop();
        stack.push(op1 - op2);
      } else if (MULTI.equals(token)) {
        final int op2 = stack.pop(), op1 = stack.pop();
        stack.push(op1 * op2);
      } else if (DIVIDE.equals(token)) {
        final int op2 = stack.pop(), op1 = stack.pop();
        stack.push(op1 / op2);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    assert stack.size() == 1;
    return stack.pop();
  }
}
