package interviews.uber._301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DfsSolution implements Solution {

  /**
   * 7 ms
   *
   * @param s
   * @return
   */
  public List<String> removeInvalidParentheses(String s) {
    int removeLeft = 0, removeRight = 0;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr == '(') {
        removeLeft++;
      } else if (chr == ')') {
        if (removeLeft > 0) {
          removeLeft--;
        } else {
          removeRight++;
        }
      }
    } // end of for loop

    final Set<String> result = new HashSet<>();
    dfs(result, s, new StringBuilder(), 0, removeLeft, removeRight, 0);
    return new ArrayList<>(result);
  }

  private static void dfs(final Set<String> result, String s, final StringBuilder sb, final int i,
                          final int removeLeft, final int removeRight, final int open) {
    if (removeLeft < 0 || removeRight < 0 || open < 0) {
      return;
    }
    if (i == s.length()) {
      if (removeLeft == 0 && removeRight == 0 && open == 0) {
        result.add(sb.toString());
      }
      return;
    }

    final char chr = s.charAt(i);
    final int len = sb.length();
    if (chr == '(') {
      dfs(result, s, sb, i + 1, removeLeft - 1, removeRight, open); // not use it
      dfs(result, s, sb.append(chr), i + 1, removeLeft, removeRight, open + 1); // use it
    } else if (chr == ')') {
      dfs(result, s, sb, i + 1, removeLeft, removeRight - 1, open); // not use it
      dfs(result, s, sb.append(chr), i + 1, removeLeft, removeRight, open - 1); // use it
    } else {
      dfs(result, s, sb.append(chr), i + 1, removeLeft, removeRight, open);
    }

    sb.setLength(len);
  }
}
