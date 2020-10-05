package uber._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  private static final Map<Character, Character> MAP = new HashMap<>();

  static {
    MAP.put(')', '(');
    MAP.put('}', '{');
    MAP.put(']', '[');
  }

  public boolean isValid(String s) {
    final char[] chars = s.toCharArray();
    final Deque<Character> stack = new ArrayDeque<>();
    for (char chr : chars) {
      switch (chr) {
        case '(':
        case '[':
        case '{':
          stack.push(chr);
          break;
        case ']':
        case '}':
        case ')':
          if (stack.isEmpty()) {
            return false;
          }
          final char mirror = MAP.get(chr);
          if (mirror != stack.pop()) {
            return false;
          }
          break;
        default:
          throw new IllegalArgumentException("Not valid char " + chr);
      }
    } // end of for loop;

    return stack.isEmpty();
  }
}
