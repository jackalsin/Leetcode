package _0901_0950._921_Minimum_Add_to_Make_Parentheses_Valid;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  private static final char LEFT = '(', RIGHT = ')';

  public int minAddToMakeValid(String s) {
    final char[] chars = s.toCharArray();
    final int n = chars.length;
    int unmatchedLeft = 0, result = 0;
    for (final char chr : chars) {
      if (chr == LEFT) {
        unmatchedLeft++;
      } else {
        assert chr == RIGHT;
        if (unmatchedLeft > 0) {
          unmatchedLeft--;
        } else {
          result++;
        }
      }
    }
    return result + unmatchedLeft;
  }
}
