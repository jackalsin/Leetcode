package interviews.oracle._125_Valid_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    for (int left = 0, right = s.length() - 1; left < right; ) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
      left++;
      right--;
    }
    return true;
  }
}
