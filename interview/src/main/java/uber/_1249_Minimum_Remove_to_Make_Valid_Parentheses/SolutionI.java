package uber._1249_Minimum_Remove_to_Make_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String minRemoveToMakeValid(String s) {
    final Deque<Integer> stack = new ArrayDeque<>();
    final Set<Integer> indexToRemove = new HashSet<>();
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      final char c = chars[i];
      if (c == '(') {
        stack.push(i);
        indexToRemove.add(i);
      } else if (c == ')') {
        if (stack.isEmpty()) {
          indexToRemove.add(i);
        } else {
          indexToRemove.remove(stack.pop());
        }
      }
    }

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      if (!indexToRemove.contains(i)) {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
