package interviews.linkedin._125_Valid_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionII implements Solution {
  @Override
  public boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    for (int left = 0, right = s.length() - 1; left < right; ++left, --right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) ++left;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) --right;
      if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
    }
    return true;
  }
}
