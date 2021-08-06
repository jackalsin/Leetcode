package linkedin._005_Longest_Palindromic_Substring;

public final class SolutionI implements Solution {
  private int minLeft = 0, minRight = 0;

  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return s;
    for (int i = 0; i < s.length(); ++i) {
      search(s, i, i);
      search(s, i, i + 1);
    }
    return s.substring(minLeft, minRight + 1);
  }

  private void search(final String s, int left, int right) {
    for (; left >= 0 && right < s.length(); left--, ++right) {
      if (s.charAt(left) != s.charAt(right)) return;
      final int len = right - left + 1;
      if (minRight - minLeft + 1 < len) {
        minLeft = left;
        minRight = right;
      }
    }
  }
}
