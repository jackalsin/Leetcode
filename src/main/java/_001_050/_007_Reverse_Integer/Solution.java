package _001_050._007_Reverse_Integer;

/**
 * @author jacka
 * @version 1.0 on 2017/1/12.
 */
public class Solution {

  /**
   * Reverse digits in an integer.
   * Example1: x = 123, return 321
   * Example2: x = -123, return -321
   *
   * @param x the original number
   * @return the reversed number if not overflow, otherwise, 0
   */
  public int reverse(int x) {
    if (x == Integer.MIN_VALUE) {
      return 0;
    }
    if (x < 0) {
      return -reversePositiveInteger(-x);
    }
    if (x == 0) {
      return 0;
    }
    return reversePositiveInteger(x);
  }

  private int reversePositiveInteger(int x) {
    int result = 0;
    while (x != 0) {
      if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && x >= 8)) {
        return 0;
      }
      result = result * 10 + x % 10;
      x /= 10;
    }
    return result;
  }
}
