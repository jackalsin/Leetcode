package _1001_1050._1021_Remove_Outermost_Parentheses;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String removeOuterParentheses(String s) {
    final StringBuilder sb = new StringBuilder();
    int leftCount = 0;
    final int n = s.length();
    for (int left = 0, right = 0; right < n; ++right) {
      if (s.charAt(right) == '(') {
        leftCount++;
      } else {
        leftCount--;
      }
      if (leftCount == 0) {
        sb.append(s, left + 1, right);
        left = right + 1;
      }
    }
    return sb.toString();
  }
}
