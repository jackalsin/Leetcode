package oracle._009_Palindrome_Number;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isPalindrome(final int x) {
    if (x < 0) {
      return false;
    }
    if (x == 0) {
      return true;
    }
    long reverse = 0, cur = x;
    while (cur != 0) {
      reverse = reverse * 10 + cur % 10;
      cur /= 10;
    }
    return reverse == x;
  }
}
