package interviews.uber._125_Valid_Palindrome;

public class Solution {
  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }

      if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
