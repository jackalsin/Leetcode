package airbnb._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/17/2021
 */
public final class SolutionI implements Solution {
  private static final Map<Character, Character> MAP = Map.of(
      ')', '(',
      ']', '[',
      '}', '{'
  );

  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) return true;
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : s.toCharArray()) {
      if (MAP.containsKey(chr)) {
        if (stack.isEmpty()) return false;
        if (stack.pop() != MAP.get(chr)) return false;
      } else {
        stack.push(chr);
      }
    }
    return stack.isEmpty();
  }
}
