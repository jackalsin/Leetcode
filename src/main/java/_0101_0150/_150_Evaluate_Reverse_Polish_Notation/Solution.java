package _0101_0150._150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) return 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (String child : tokens) {
      if (child.matches("[+\\-*/]")) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        switch (child) {
          case "+":
            stack.push(num1 + num2);
            break;
          case "-":
            stack.push(num2 - num1);
            break;
          case "*":
            stack.push(num1 * num2);
            break;
          case "/":
            stack.push(num2 / num1);
            break;
          default:
            throw new UnsupportedOperationException(child);
        }
      } else {
        stack.push(Integer.valueOf(child));
      }
    }
    return stack.pop();
  }
}
