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
    generateParenthesis(n, result, "", 0, 0);
    return result;
  }

  private void generateParenthesis(final int n, final List<String> result, String cur, int
      leftCount, int rightCount) {
    if (leftCount == n && rightCount == n) {
      result.add(cur);
      return;
    }

    if (leftCount < n) {
      generateParenthesis(n, result, cur + "(", leftCount + 1, rightCount);
    }

    if (rightCount < leftCount) {
      generateParenthesis(n, result, cur + ")", leftCount, rightCount + 1);
    }
  }
}
