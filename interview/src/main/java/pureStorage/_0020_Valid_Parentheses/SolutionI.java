package pureStorage._0020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  private static final Map<Character, Character> MAP = new HashMap<Character, Character>() {{
    put('{', '}');
    put('(', ')');
    put('[', ']');
  }};

  public boolean isValid(String s) {
    if (s == null) {
      return true;
    }
    if (s.isEmpty()) {
      return true;
    }
    final Deque<Character> stack = new ArrayDeque<>();
    final char[] chars = s.toCharArray();
    for (char chr : chars) {
      if (chr == '(' || chr == '[' || chr == '{') {
        stack.push(chr);
      } else {
        if (stack.isEmpty() || MAP.get(stack.peek()) != chr) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
