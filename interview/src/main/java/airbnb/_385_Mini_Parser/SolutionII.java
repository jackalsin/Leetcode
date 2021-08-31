package airbnb._385_Mini_Parser;

import definition.nestedInteger._385_Mini_Parser.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/30/2021
 */
public final class SolutionII implements Solution {
  @Override
  public NestedInteger deserialize(String s) {
    if (s == null || s.isEmpty()) return null;
    if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s));
    final Deque<NestedInteger> stack = new ArrayDeque<>();
    NestedInteger last = null;
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (c == '[') {
        stack.push(new NestedInteger());
      } else if (c == ']') {
        last = stack.pop();
        if (!stack.isEmpty()) {
          stack.peek().add(last);
        }
      } else if (c == '-' || Character.isDigit(c)) {
        int sign = 1;
        if (c == '-') {
          sign = -1;
          i++;
        }
        int num = s.charAt(i) - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + (s.charAt(i + 1) - '0');
          ++i;
        }
        stack.peek().add(new NestedInteger(sign * num));
      }
    }
    return last;
  }
}
