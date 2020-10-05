package uber._301_Remove_Invalid_Parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class BfsSolution implements Solution {
  public List<String> removeInvalidParentheses(String s) {
    final List<String> result = new ArrayList<>();
    if (s == null) {
      return result;
    }
    final Set<String> visited = new HashSet<>();
    final Queue<String> q = new ArrayDeque<>();
    q.add(s);
    visited.add(s);
    boolean found = false;
    while (!q.isEmpty()) {
      final String toRemove = q.remove();
      if (isValid(toRemove)) {
        result.add(toRemove);
        found = true;
      }
      if (found) continue;
      for (int i = 0; i < toRemove.length(); i++) {
        final char chr = toRemove.charAt(i);
        if (chr != '(' && chr != ')') continue;
        final String nextStr = toRemove.substring(0, i) + toRemove.substring(i + 1);
        if (!visited.contains(nextStr)) {
          visited.add(nextStr);
          q.add(nextStr);
        }
      }
    }
    return result;
  }

  private static boolean isValid(final String s) {
    int leftCount = 0;
    for (char chr : s.toCharArray()) {
      if (chr == '(') leftCount++;
      else if (chr == ')') leftCount--;
      if (leftCount < 0) return false;
    }
    return leftCount == 0;
  }
}
