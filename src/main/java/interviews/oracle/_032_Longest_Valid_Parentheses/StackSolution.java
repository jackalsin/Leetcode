package interviews.oracle._032_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class StackSolution implements Solution {
  @Override
  public int longestValidParentheses(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    /* only contains the index not match */
    final Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          final int peek = stack.peek();
          if (peek != -1 && s.charAt(peek) == '(') {
            stack.pop();
          } else {
            stack.push(i);
          }
        }
      }
    } // end of for
    int max = 0, prev = s.length();
    while (!stack.isEmpty()) {
      final int cur = stack.pop();
      max = Math.max(max, prev - cur - 1);
      prev = cur;
    }
    return max;
  }
}
