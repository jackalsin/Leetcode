package airbnb._125_Valid_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public final class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    for (int left = 0, right = s.length() - 1; left < right; ) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
      if (left >= right) {
        break;
      }
      final char leftChar = Character.toLowerCase(s.charAt(left)),
          rightChar = Character.toLowerCase(s.charAt(right));
      if (leftChar != rightChar) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
