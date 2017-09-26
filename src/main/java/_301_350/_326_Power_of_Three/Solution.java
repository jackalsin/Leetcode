package _301_350._326_Power_of_Three;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class Solution {
  public boolean isPowerOfThree(int n) {
//    return n > 0 && (n == 1 || (n % 3 == 0) && isPowerOfThree(n / 3));
    return henSaoDeMethod(n);
  }
  private boolean henSaoDeMethod(int n) {
    return n > 0 && (1162261467 % n == 0);
  }
}
