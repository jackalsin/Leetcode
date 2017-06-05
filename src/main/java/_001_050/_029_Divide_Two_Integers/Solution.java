package _001_050._029_Divide_Two_Integers;

/**
 * @author jacka
 * @version 1.0 on 1/24/2017.
 */
public class Solution {
  /**
   * Divide two integers without using multiplication, division and mod operator. If it is
   * overflow, return MAX_INT.
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {
    if (divisor == 0) {
      throw new IllegalArgumentException("The divisor cannot be zero");
    } else if (Integer.MIN_VALUE == dividend && Math.abs(divisor) == 1){
      return divisor == 1 ? Integer.MIN_VALUE: Integer.MAX_VALUE;
    } else if (divisor == Integer.MIN_VALUE) {
      return 0;
    }else {
      int result = 0;
      int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1: -1;
      long dividendLong = Math.abs((long) dividend);
      long divisorLong = Math.abs(divisor);
      while (dividendLong >= divisorLong) {
        long cur = divisorLong, multiple = 1;
        while (dividendLong >= (cur << 1)) {
          multiple <<= 1;
          cur <<= 1;
        }
        dividendLong -= cur;
        result += multiple;
      }
      return sign * result;
    }
  }
}
