package byteDance._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 3/30/2021
 */
public final class DpSolution implements Solution {
  public String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return s;
    }
    final int n = s.length();
    final boolean[][] isPalindrome = new boolean[n][n];
    int maxStart = 0, maxEnd = 0;
    for (int left = n - 1; left >= 0; --left) {
      isPalindrome[left][left] = true;
      for (int right = left + 1; right < n; ++right) {
        if (s.charAt(left) == s.charAt(right)) {
          isPalindrome[left][right] =
              left + 1 >= right - 1 ? true : isPalindrome[left + 1][right - 1];
          if (isPalindrome[left][right] && (maxEnd - maxStart <= right - left)) {
            maxStart = left;
            maxEnd = right;
          }
        }
      } // end of right
    }
    return s.substring(maxStart, maxEnd + 1);
  }
}
