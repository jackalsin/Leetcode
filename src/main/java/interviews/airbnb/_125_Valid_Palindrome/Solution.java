package interviews.airbnb._125_Valid_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public class Solution {
  private int left, right;

  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    left = 0;
    right = s.length() - 1;
    nextLeft(s);
    nextRight(s);
    while (left < right) {
      final char leftChar = s.charAt(left), rightChar = s.charAt(right);
      if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
        return false;
      }
      left++;
      right--;
      nextLeft(s);
      nextRight(s);
    }
    return true;
  }

  private void nextLeft(String s) {
    while (left < s.length()) {
      final char chr = s.charAt(left);
      if (Character.isLetterOrDigit(chr)) break;
      left++;
    }
  }

  private void nextRight(final String s) {
    while (right >= 0) {
      final char chr = s.charAt(right);
      if (Character.isLetterOrDigit(chr)) {
        break;
      }
      right--;
    }
  }

}
