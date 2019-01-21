package interviews.airbnb._009_Palindrome_Number;

public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    long reverse = 0, cur = x;

    while (cur != 0) {
      reverse = reverse * 10 + cur % 10;
      cur /= 10;
    }

    return reverse == x;
  }
}
