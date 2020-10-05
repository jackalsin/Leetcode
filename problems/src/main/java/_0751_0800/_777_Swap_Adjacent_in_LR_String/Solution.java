package _0751_0800._777_Swap_Adjacent_in_LR_String;

/**
 * @author jacka
 * @version 1.0 on 3/5/2018.
 */
public class Solution {
  private static final String X = "X";
  private static final char X_CHAR = 'X', L = 'L', R = 'R';

  /**
   * @see
   * <a href='https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/217070/Python-using-corresponding-position-'>explanation</a>
   * Time Complexity: O(N)
   */
  public boolean canTransform(String start, String end) {
    if (!start.replace(X, "").equals(end.replace(X, ""))) {
      return false;
    }
    for (int p1 = 0, p2 = 0; p1 <= start.length() && p2 <= end.length(); p1++, p2++) {
      while (p1 < start.length() && start.charAt(p1) == X_CHAR) {
        p1++;
      }
      while (p2 < end.length() && end.charAt(p2) == X_CHAR) {
        p2++;
      }
      if (p1 == start.length() && p2 == end.length()) {
        return true;
      }
      if (p1 == start.length() || p2 == end.length()) {
        return false;
      }

      // L can be only moved to left, so p1 should be greater than or equals to p2
      if (start.charAt(p1) == L && p1 < p2) {
        return false;
      }
      if (end.charAt(p2) == R && p2 < p1) {
        return false;
      }

    }
    return false;
  }
}
