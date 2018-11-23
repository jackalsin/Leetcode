package _0201_0250._231_Power_of_Two;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n == Integer.MIN_VALUE) return false;
    while (n != 1) {
      if ((n & 1) != 0) {
        return false;
      } else {
        n >>>= 1;
      }
    }
    return true;
  }

  /**
   * just more concise;
   *
   * @param n
   * @return
   */
  private boolean bitcount(int n) {
    return Integer.bitCount(n) == 1 && n != Integer.MIN_VALUE;
  }
}
