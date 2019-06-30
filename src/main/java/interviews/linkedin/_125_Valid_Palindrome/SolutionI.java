package interviews.linkedin._125_Valid_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public final class SolutionI implements Solution {
  public boolean isPalindrome(String s) {
    for (int left = 0, right = s.length() - 1; left < right; ) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
