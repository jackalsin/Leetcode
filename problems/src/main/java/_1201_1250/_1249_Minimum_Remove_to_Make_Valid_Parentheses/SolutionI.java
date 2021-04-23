package _1201_1250._1249_Minimum_Remove_to_Make_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/22/2021
 */
public final class SolutionI implements Solution {
  public String minRemoveToMakeValid(String s) {
    final Deque<Integer> stack = new ArrayDeque<>();
    final Set<Integer> indexToRemove = new HashSet<>();
    final char[] chars = s.toCharArray();
    final int len = chars.length;
    for (int i = 0; i < len; ++i) {
      final char chr = chars[i];
      if (chr == '(') {
        stack.push(i);
        indexToRemove.add(i);
      } else if (chr == ')') {
        if (stack.isEmpty()) {
          indexToRemove.add(i);
        } else {
          final int toRemove = stack.pop();
          indexToRemove.remove(toRemove);
        }
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; ++i) {
      final char chr = chars[i];
      if (indexToRemove.contains(i)) continue;
      sb.append(chr);
    }
    return sb.toString();
  }
}
