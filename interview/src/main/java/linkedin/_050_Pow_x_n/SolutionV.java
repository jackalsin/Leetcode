package linkedin._050_Pow_x_n;

/**
 * @author jacka
 * @version 1.0 on 9/25/2019
 */
public final class SolutionV implements Solution {

  public double myPow(double x, int n) {
    if (x == 0) {
      return n == 0 ? 1 : 0;
    } else if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    } else if (n == Integer.MIN_VALUE) {
      return 1d / myPow(x, -(n + 1)) / x;
    } else if (n < 0) {
      return 1d / myPow(x, -n);
    } else {
      final double half = myPow(x, n / 2);
      return half * half * (n % 2 == 1 ? x : 1);
    }
  }
}
