package linkedin._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  private static final Map<Character, Character> MAP = new HashMap<>() {{
    put('}', '{');
    put(')', '(');
    put(']', '[');
  }};

  @Override
  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();

    for (char chr : s.toCharArray()) {
      if (chr == '(' || chr == '{' || chr == '[') {
        stack.push(chr);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        final char matchChr = MAP.get(chr);
        if (stack.pop() != matchChr) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
