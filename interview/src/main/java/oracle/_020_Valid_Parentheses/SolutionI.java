package oracle._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  private static final Map<Character, Character> MAP = new HashMap<Character, Character>() {{
    put('[', ']');
    put('{', '}');
    put('(', ')');
  }};

  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : s.toCharArray()) {
      if (MAP.containsKey(chr)) {
        stack.push(MAP.get(chr));
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        if (stack.pop() != chr) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
