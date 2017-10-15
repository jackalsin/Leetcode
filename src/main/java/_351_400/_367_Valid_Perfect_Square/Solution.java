package _351_400._367_Valid_Perfect_Square;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
public class Solution {
  public boolean isPerfectSquare(int num) {
//    return binarySearch(num);
    return newton(num);
  }

  private boolean newton(final int num) {
    if (num <= 0) {
      return false;
    }
    long x = num;
    // x1 = (x0 - f(x)/f'(x))
    while (x * x > num) {
      x = (x * x + num) / 2 / x;
    }
    return x * x == num;
  }

  private boolean binarySearch(final int num) {
    if (num <= 0) {
      return false;
    }
    long start = 0, end = num;
    while (start <= end) { // ==
      long mid = (end - start) / 2 + start;
      long midSquare = mid * mid;
      if (midSquare == (long) num) {
        return true;
      } else if (midSquare < (long) num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }
}
