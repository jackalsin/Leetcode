package facebook.practice.Balance_Brackets;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  private static final Map<Character, Character> MAP = Map.of(
      '}', '{', ']', '[',
      ')', '(');

  public boolean isBalanced(String s) {
    if (s == null || s.isEmpty()) return true;
    final Deque<Character> stack = new ArrayDeque<>();
    final char[] chars = s.toCharArray();
    for (final char c : chars) {
      if (MAP.containsKey(c)) {
        if (stack.isEmpty() || stack.pop() != MAP.get(c)) return false;
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
