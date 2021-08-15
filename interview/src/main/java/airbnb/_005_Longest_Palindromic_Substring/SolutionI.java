package airbnb._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  private int maxLeft = 0, maxRight = 0, maxLen = 1;

  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return null;
    final int len = s.length();
    for (int i = 0; i < len; ++i) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }
    return s.substring(maxLeft, maxRight + 1);
  }

  private void expand(final String s, int i, int j) {
    for (; i >= 0 && j < s.length(); --i, ++j) {
      if (s.charAt(i) != s.charAt(j)) break;
      final int len = j - i + 1;
      if (len > maxLen) {
        maxLen = len;
        maxLeft = i;
        maxRight = j;
      }
    }
  }
}
