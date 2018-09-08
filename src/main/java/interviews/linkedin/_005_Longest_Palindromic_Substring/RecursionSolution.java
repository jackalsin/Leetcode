package interviews.linkedin._005_Longest_Palindromic_Substring;

public final class RecursionSolution implements Solution {
  private int left = 0, maxLen = 0;

  @Override
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      longestPalindrome(s, i, i);
      longestPalindrome(s, i, i + 1);
    }
    return s.substring(left, left + maxLen);
  }

  private void longestPalindrome(final String s, int left, int right) {
    int len = left == right ? -1 : 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
      len += 2;
    }
    if (maxLen < len) {
      maxLen = len;
      this.left = left + 1;
    }
  }
}
