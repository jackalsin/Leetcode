package _1001_1050._1003_Check_If_Word_Is_Valid_After_Substitutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhixi
 * @version 1.0 on 10/16/2020
 */
public final class SolutionI implements Solution {
  private static final char A = 'a', B = 'b', C = 'c';

  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : s.toCharArray()) {
      if (chr == C) {
        if (stack.isEmpty() || stack.pop() != B) return false;
        if (stack.isEmpty() || stack.pop() != A) return false;
      } else {
        stack.push(chr);
      }
    }
    return stack.isEmpty();
  }
}
