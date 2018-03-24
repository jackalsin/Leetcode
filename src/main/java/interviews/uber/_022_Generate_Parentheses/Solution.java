package interviews.uber._022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  public List<String> generateParenthesis(int n) {
    final StringBuilder sb = new StringBuilder();
    final List<String> result = new ArrayList<>();
    dfs(result, sb, 2 * n, n, n);
    return result;
  }

  /**
   * @param result
   * @param sb
   * @param n      total number of left and right parenthesis.
   * @param left
   * @param right
   */
  private static void dfs(final List<String> result, final StringBuilder sb, final int n,
                          final int left, final int right) {
    if (sb.length() == n) {
      result.add(sb.toString());
      return;
    }
    if (left > 0) {
      sb.append('(');
      dfs(result, sb, n, left - 1, right);
      sb.setLength(sb.length() - 1);
    }
    if (right > left) {
      sb.append(')');
      dfs(result, sb, n, left, right - 1);
      sb.setLength(sb.length() - 1);
    }
  }
}
