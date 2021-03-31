package byteDance._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 3/30/2021
 */
public final class BruteForceSolution implements Solution {
  private int maxStart = 0, maxEnd = 0;

  public String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return s;
    }
    for (int i = 0; i < s.length(); ++i) {
      extend(s, i, i);
      extend(s, i, i + 1);
    }
    return s.substring(maxStart, maxEnd + 1);
  }

  private void extend(final String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        return;
      }
      if (right - left >= maxEnd - maxStart) {
        maxStart = left;
        maxEnd = right;
      }
      --left;
      ++right;
    }
  }
}
