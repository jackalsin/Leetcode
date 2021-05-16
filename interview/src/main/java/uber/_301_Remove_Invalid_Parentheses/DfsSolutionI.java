package uber._301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/15/2021
 */
public final class DfsSolutionI implements Solution {
  private static final char LEFT = '(', RIGHT = ')';

  public List<String> removeInvalidParentheses(String s) {
    int leftToRemove = 0, rightToRemove = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (c == '(') leftToRemove++;
      else if (c == ')') {
        if (leftToRemove > 0) leftToRemove--;
        else rightToRemove++;
      }
    }
    final Set<String> result = new HashSet<>();
    dfs(result, s, leftToRemove, rightToRemove, 0, 0, new StringBuilder());
    return new ArrayList<>(result);
  }

  private void dfs(final Set<String> result, final String s, final int leftToRemove, final int rightToRemove,
                   final int open, final int i, final StringBuilder sb) {
    if (open < 0 || leftToRemove < 0 || rightToRemove < 0) return;
    if (i == s.length()) {
      if (leftToRemove == 0 && rightToRemove == 0 && open == 0) {
        result.add(sb.toString());
      }
      return;
    }
    final int len = sb.length();
    final char c = s.charAt(i);
    if (c == LEFT) {
      dfs(result, s, leftToRemove - 1, rightToRemove, open, i + 1, sb);
      dfs(result, s, leftToRemove, rightToRemove, open + 1, i + 1, sb.append(c));
    } else if (c == RIGHT) {
      dfs(result, s, leftToRemove, rightToRemove - 1, open, i + 1, sb);
      dfs(result, s, leftToRemove, rightToRemove, open - 1, i + 1, sb.append(c));
    } else {
      dfs(result, s, leftToRemove, rightToRemove, open, i + 1, sb.append(c));
    }
    sb.setLength(len);
  }
}
