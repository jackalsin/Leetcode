package linkedin._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/20/2019
 */
public final class SolutionIII implements Solution {
  private static final Map<Character, Character> MAP = Map.of(
      '}', '{',
      ']', '[',
      ')', '('
  );

  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) return true;
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : s.toCharArray()) {
      if (MAP.containsKey(chr)) {
        if (stack.isEmpty() || stack.peek() != MAP.get(chr)) return false;
        stack.pop();
      } else {
        stack.push(chr);
      }
    }
    return stack.isEmpty();
  }
}
