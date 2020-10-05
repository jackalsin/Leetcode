package oracle.braceTransform;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 12/7/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String transform(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    final char[] chars = input.toCharArray();
    final StringBuilder sb = new StringBuilder();
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (chr == '(') {
        stack.push(i);
      } else if (chr == ')') {
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          if (chars[stack.peek()] == '(') { // match
            sb.setCharAt(stack.pop(), '0');
            continue;
          } else {
            stack.push(i);
          }
        }
      }
      sb.append(chr);
    }

    final StringBuilder res = new StringBuilder();
    for (int i = 0; i < sb.length(); ++i) {
      final char chr = sb.charAt(i);
      if (chr == '(') {
        res.append("1");
      } else if (chr == ')') {
        res.append("-1");
      } else {
        res.append(chr);
      }
    }

    return res.toString();
  }
}
