package apple._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public final class SolutionI implements Solution {
  private static final Map<Character, Character> RIGHT_TO_LEFT = Map.of(
      '}', '{',
      ']', '[',
      ')', '('
  );

  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : s.toCharArray()) {
      if (RIGHT_TO_LEFT.containsKey(chr)) {
        if (stack.isEmpty()) return false;
        if (stack.pop() != RIGHT_TO_LEFT.get(chr)) {
          return false;
        }
      } else {
        stack.push(chr);
      }
    }
    return stack.isEmpty();
  }
}
