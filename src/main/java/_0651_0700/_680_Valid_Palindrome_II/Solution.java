package _0651_0700._680_Valid_Palindrome_II;

public class Solution {
  public boolean validPalindrome(String s) {
    return validPalindrome(s, 0, s.length() - 1, false);
  }

  private static boolean validPalindrome(String s, int left, int right, boolean hasDelete) {
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
        continue;
      }
      if (hasDelete) {
        return false;
      }
      return validPalindrome(s, left + 1, right, true) ||
          validPalindrome(s, left, right - 1, true);
    }
    return true;
  }
}
