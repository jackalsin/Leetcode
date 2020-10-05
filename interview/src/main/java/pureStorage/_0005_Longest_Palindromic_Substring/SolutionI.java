package pureStorage._0005_Longest_Palindromic_Substring;

public final class SolutionI implements Solution {
  private String minString = "";

  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }
    return minString;
  }

  private void expand(final String s, int i, int j) {
    for (; i >= 0 && j < s.length(); --i, ++j) {
      final char iChar = s.charAt(i), jChar = s.charAt(j);
      if (iChar != jChar) return;
      if (minString.length() < j - i + 1) {
        minString = s.substring(i, j + 1);
      }
    }
  }
}
