package _301_350._301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/12/2017.
 */
public final class DfsSolution implements Solution {

  @Override
  public List<String> removeInvalidParentheses(String s) {
    final List<String> result = new ArrayList<>();
    removeInvalidParenthesesHelper(result, s, 0, 0, new char[]{'(', ')'});
    return result;
  }

  private void removeInvalidParenthesesHelper(
      final List<String> result, final String s, final int iStart, final int jStart,
      final char[] pair) {
    int stack = 0;
    for (int i = iStart; i < s.length(); ++i) {
      if (s.charAt(i) == pair[0]) stack++;
      else if (s.charAt(i) == pair[1]) stack--;

      if (stack < 0) { // so removing one pair[1] will let the string valid
        for (int j = jStart; j <= i; ++j) {
          // try to remove every possible
          if (s.charAt(j) == pair[1] && (j == jStart ||  s.charAt(j - 1) != s.charAt(j))) {
//            if (j == jStart || s.charAt(j - 1) == s.charAt(j)) continue;
            removeInvalidParenthesesHelper(result, s.substring(0, j) + s.substring(j + 1), i, j,
                pair);
          }
        }
        return;
      }
    } // end of for loop i;

    if (pair[0] == '(') {
      removeInvalidParenthesesHelper(result, new StringBuilder(s).reverse().toString(), 0, 0 ,
          new char[]{')', '('});
    } else {
      result.add(new StringBuilder(s).reverse().toString());
    }
  }


}
