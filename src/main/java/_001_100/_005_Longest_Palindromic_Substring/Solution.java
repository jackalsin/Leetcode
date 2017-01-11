package _001_100._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 1/11/2017.
 */
public class Solution {
  // when needing global variables
  private int maxLen = 0;
  private int left = 0;

  public String longestPalindrome(String s) {
    if (s == null) {
      return "";
    } else if (s.length() < 2) {
      return s;
    } else {
      for (int i = 0; i < s.length(); i++) {
        scanLeftRight(s, i, i);
        scanLeftRight(s, i, i + 1);
      }
      return s.substring(left, left + maxLen);
    }
  }

  private void scanLeftRight(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
//    int curLen = left - right + 1 - 2
    int curLen = right - left - 1;
    if (maxLen < curLen) {
      this.left = left + 1;
      maxLen = curLen;
    }
  }
}
