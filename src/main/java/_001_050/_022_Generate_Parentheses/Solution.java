package _001_050._022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public class Solution {
  public List<String> generateParenthesis(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n cannot be lower than zero, but now is " + n);
    } else {
      List<String> result = new ArrayList<>();
      generateParenthesisHelper(result, new StringBuilder(), n, n);
      return result;
    }
  }

  private void generateParenthesisHelper(List<String> result,
                                         StringBuilder curPath,
                                         int left, int right) {
    if (right == 0) {
      result.add(curPath.toString());
    } else {
      if (left > 0) {
        StringBuilder nextLeftBuilder = new StringBuilder(curPath).append("(");
        generateParenthesisHelper(result, nextLeftBuilder, left - 1, right);
      }
      if (right > left) {
        StringBuilder nextRightBuilder = new StringBuilder(curPath).append(")");
        generateParenthesisHelper(result, nextRightBuilder, left, right - 1);
      }
    }
  }
}
