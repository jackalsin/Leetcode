package _001_050._009_Palindrome_Number;

/**
 * @author jacka
 * @version 1.0 on 2017/1/13.
 */
public class Solution {

  public boolean isPalindrome(int x) {
    return x >= 0 && (x == 0 || isPalindromeHelper(x));
  }

  private boolean isPalindromeHelper(int x) {
    int digits = countDigits(x);
    int left = digits - 1;
    int right = 0;
    while (left > right) {
      int rightDigit = x / ((int) Math.pow(10, right)) % 10;
      int leftDigit = x / ((int) Math.pow(10, left)) % 10;
      if (leftDigit != rightDigit) {
        return false;
      }
      left--;
      right++;
    }
    return true;
  }

  private int countDigits(int x) {
    int count = 0;
    while (x > 0) {
      x /= 10;
      count++;
    }
    return count;
  }
}
