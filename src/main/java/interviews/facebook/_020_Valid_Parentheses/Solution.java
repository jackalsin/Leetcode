package interviews.facebook._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static final Map<Character, Character> map = new HashMap<>() {{
    put(']', '[');
    put('}', '{');
    put(')', '(');
  }};

  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : s.toCharArray()) {
      switch (chr) {
        case '{':
        case '(':
        case '[':
          stack.push(chr);
          break;
        case ']':
        case '}':
        case ')':
          final char toMatch = map.get(chr);
          if (stack.isEmpty() || stack.pop() != toMatch) {
            return false;
          }
          break;
      }
    }

    return stack.isEmpty();
  }
}
