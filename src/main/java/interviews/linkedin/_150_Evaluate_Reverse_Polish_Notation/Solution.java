package interviews.linkedin._150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class Solution {

  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }
    Deque<Long> stack = new ArrayDeque<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        long num2 = stack.pop();
        long num1 = stack.pop();
        if (token.equals("+")) {
          stack.push(num1 + num2);
        } else if (token.equals("-")) {
          stack.push(num1 - num2);
        } else if (token.equals("*")) {
          stack.push(num1 * num2);
        }
        if (token.equals("/")) {
          stack.push(num1 / num2);
        }
      } else {
        stack.push(Long.valueOf(token));
      }
    }
    assert stack.size() == 1;
    return stack.pop().intValue();
  }
}
