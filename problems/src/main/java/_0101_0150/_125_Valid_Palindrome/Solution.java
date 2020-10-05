package _0101_0150._125_Valid_Palindrome;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/26/2017.
 */
public class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    } else {
      int left = 0, right = s.length() - 1;
      while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
          left++;
        }
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
          right--;
        }
        if (Character.toUpperCase(s.charAt(left++))!= Character.toUpperCase(s.charAt(right--))) {
          return false;
        }
      }
      return true;
    }
  }
}

