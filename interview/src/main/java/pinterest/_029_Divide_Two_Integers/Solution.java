package pinterest._029_Divide_Two_Integers;

public class Solution {
  /**
   * Time Complexity: O( (log(dividend / divisor) ^ 2 )
   * 每次都是  (2^ 31 - 1) / 1
   *
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int sign = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) ? -1 : 1;
    long dividendLong = Math.abs((long) dividend), divisorLong = Math.abs((long) divisor);
    int result = 0;
    while (dividendLong >= divisorLong) {
      long temp = divisorLong, multiple = 1;
      while (dividendLong >= (temp << 1)) {
        temp <<= 1;
        multiple <<= 1;
      }
      dividendLong -= temp;
      result += multiple;
    }
    return result * sign;
  }
}
