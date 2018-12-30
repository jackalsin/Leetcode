package interviews.uber._022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  public List<String> generateParenthesis(int n) {
    final List<String> result = new ArrayList<>();
    dfs(result, "", n, n);
    return result;
  }

  private static void dfs(final List<String> result, final String s, final int left, final int right) {
    if (left < 0 || right < 0) {
      return;
    } else if (left == 0 && right == 0) {
      result.add(s);
      return;
    }
//    assert 0 <= left && left <= right;

    if (left > 0) {
      dfs(result, s + "(", left - 1, right);
    }

    if (left < right) {
      dfs(result, s + ")", left, right - 1);
    }
  }
}
