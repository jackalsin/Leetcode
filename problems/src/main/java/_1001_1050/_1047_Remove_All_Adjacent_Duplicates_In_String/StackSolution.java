package _1001_1050._1047_Remove_All_Adjacent_Duplicates_In_String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class StackSolution implements Solution {
  @Override
  public String removeDuplicates(String S) {
    final Deque<Character> stack = new ArrayDeque<>();
    for (final char chr : S.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == chr) {
        stack.pop();
      } else {
        stack.push(chr);
      }
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
