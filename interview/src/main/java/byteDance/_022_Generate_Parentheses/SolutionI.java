package byteDance._022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/3/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> generateParenthesis(int n) {
    final List<String> result = new ArrayList<>();
    dfs(result, n, 0, new StringBuilder(), 0, 0);
    return result;
  }

  private static void dfs(final List<String> result, final int n, final int i,
                          final StringBuilder sb, final int left, final int right) {
    if (i == 2 * n) {
      result.add(sb.toString());
      return;
    }
    final int len = sb.length();
    if (left > right) {
      sb.append(')');
      dfs(result, n, i + 1, sb, left, right + 1);
      sb.setLength(len);
    }
    if (left < n) {
      sb.append('(');
      dfs(result, n, i + 1, sb, 1 + left, right);
      sb.setLength(len);
    }
  }
}
