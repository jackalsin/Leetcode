package interviews.linkedin.mianjing._005_Longest_Palindromic_Substring;

public final class RecursionSolution implements Solution {
  private int maxLen = 0;
  private int left = 0;

  /**
   * Time Complexity: O(N ^ 2)
   * Space Complexity: O(1)
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    for (int i = 0; i < s.length(); i++) {
      longest(s, i, i);
      longest(s, i, i + 1);
    }
    return s.substring(left, left + maxLen);
  }

  private void longest(final String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    final int curLen = right - left - 1;
    if (maxLen < curLen) {
      this.left = left + 1;
      maxLen = curLen;
    }
  }
}
