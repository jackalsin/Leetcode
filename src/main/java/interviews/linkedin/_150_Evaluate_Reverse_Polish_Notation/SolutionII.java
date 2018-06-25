package interviews.linkedin._150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionII implements Solution {

  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }
    final Deque<Integer> stack = new ArrayDeque<>();

    for (final String t : tokens) {
      switch (t) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          stack.push(-stack.pop() + stack.pop());
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          final int second = stack.pop(), first = stack.pop();
          stack.push(first / second);
          break;
        default:
          stack.push(Integer.parseInt(t));
      }
    }
    assert stack.size() == 1;
    return stack.pop();
  }
}
