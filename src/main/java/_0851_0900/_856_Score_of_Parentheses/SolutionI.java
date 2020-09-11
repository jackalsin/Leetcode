package _0851_0900._856_Score_of_Parentheses;

/**
 * @author jacka
 * @version 1.0 on 9/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int scoreOfParentheses(String S) {
    final char[] chars = S.toCharArray();
    int res = 0;
    for (int i = 0, l = 0; i < chars.length; ++i) {
      if (chars[i] == '(') {
        l++;
      } else {
        l--;
        // 实际上只需要计算'()'的价值就可以
        if (chars[i - 1] == '(') {
          res += (1 << l);
        }
      }
    }
    return res;
  }
}