package interviews.airbnb._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public class Solution {
  private static final Map<Character, Character> MAP = new HashMap<Character, Character>() {{
    put(')', '(');
    put('}', '{');
    put(']', '[');
  }};

  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();
    for (char chr : s.toCharArray()) {
      if (chr == '(' || chr == '[' || chr == '{') {
        stack.push(chr);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        if (MAP.get(chr) != stack.pop()) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
