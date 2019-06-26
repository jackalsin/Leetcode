package interviews.linkedin._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 6/25/2019
 */
public final class SolutionII implements Solution {
  private static final Map<Character, Character> MAP = new HashMap<Character, Character>() {{
    put(')', '(');
    put(']', '[');
    put('}', '{');
  }};

  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();
    final Set<Character> left = new HashSet<>(MAP.values());
    for (final char chr : s.toCharArray()) {
      if (left.contains(chr)) {
        stack.push(chr);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        if (stack.peek() != MAP.get(chr)) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
