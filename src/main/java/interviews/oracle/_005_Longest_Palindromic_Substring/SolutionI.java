package interviews.oracle._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
public final class SolutionI implements Solution {
  private int start = 0, end = 0;

  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    for (int i = 0; i < s.length(); ++i) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }
    return s.substring(start, end + 1);
  }

  private void expand(final String s, int i, int j) {
    for (; i >= 0 && j < s.length(); --i, ++j) {
      if (s.charAt(i) != s.charAt(j)) return;
      final int curLen = j - i + 1;
      if (curLen > end - start + 1) {
        start = i;
        end = j;
      }
    }
  }
}
