package airbnb._009_Palindrome_Number;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isPalindrome(final int x) {
    if (x < 0) return false;
    int res = 0, src = x;
    while (src != 0) {
      res = res * 10 + src % 10;
      src /= 10;
    }
    return res == x;
  }
}
