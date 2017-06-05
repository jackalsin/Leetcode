package _001_050._050_Pow_x_n;

/**
 * @author jacka
 * @version 1.0 on 3/2/2017.
 */
public class Solution {
  public double myPow(double x, int n) {
    if (n == 0) {
      if (x == 0) {
        return 0;
      } else {
        return 1;
      }
    } else if (n == Integer.MIN_VALUE) {
      return 1d / myPowPositiveNPositiveX(x, -(n + 1)) / x;
    } else if (n < 0) {
      return 1d / myPowPositiveNPositiveX(x, -n);
    } else {
      int sign = (x < 0 && n % 2 != 0) ? -1 : 1;
      return sign * myPowPositiveNPositiveX(Math.abs(x), n);
    }
  }

  double myPowPositiveNPositiveX(double x, int n) {
    if (n == 1) return x;
    return myPowPositiveNPositiveX(x*x, n / 2) * (n % 2 == 0 ? 1: x);
  }
}
