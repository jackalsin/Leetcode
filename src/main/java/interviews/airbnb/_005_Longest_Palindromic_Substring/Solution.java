package interviews.airbnb._005_Longest_Palindromic_Substring;

public class Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    String maxString = "";
    for (int i = 0; i < s.length(); i++) {
      final String odd = longestPalindrome(s, i, i),
          even = longestPalindrome(s, i, i + 1);
      if (odd.length() > maxString.length()) {
        maxString = odd;
      }
      if (even.length() > maxString.length()) {
        maxString = even;
      }
    }
    return maxString;
  }

  private static String longestPalindrome(String s, int i, int j) {
    for (; i >= 0 && j < s.length(); i--, j++) {
      if (s.charAt(i) != s.charAt(j)) {
        break;
      }
    }
    return s.substring(i + 1, j);
  }
}
