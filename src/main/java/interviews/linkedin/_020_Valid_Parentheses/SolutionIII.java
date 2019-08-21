package interviews.linkedin._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/20/2019
 */
public final class SolutionIII implements Solution {
  private static final Map<Character, Character> MAP = new HashMap<Character, Character>() {{
    put('}', '{');
    put(']', '[');
    put(')', '(');
  }};

  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    final Deque<Character> stack = new ArrayDeque<>();
    for (char chr : s.toCharArray()) {
      if (chr == '[' || chr == '(' || chr == '{') {
        stack.push(chr);
      } else {
        final char check = MAP.get(chr);
        if (stack.isEmpty() || stack.pop() != check) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
