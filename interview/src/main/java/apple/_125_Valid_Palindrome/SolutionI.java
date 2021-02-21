package apple._125_Valid_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 2/21/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
      final char leftChar = Character.toLowerCase(s.charAt(left)),
          rightChar = Character.toLowerCase(s.charAt(right));
      if (leftChar != rightChar) return false;
      left++;
      right--;
    }
    return true;
  }
}
