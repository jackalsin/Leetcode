package interviews.oracle._050_Pow_x_n;

/**
 * @author jacka
 * @version 1.0 on 10/24/2019
 */
public final class SolutionI implements Solution {
  @Override
  public double myPow(double x, int n) {
    if (n == 0) {
      return x == 0 ? 0 : 1;
    }
    if (n == Integer.MIN_VALUE) {
      return myPow(x, n + 1) / x;
    }
    if (n < 0) {
      return 1d / myPow(x, -n);
    }
    if (n == 1) {
      return x;
    }
    final double half = myPow(x, n / 2);
    return half * half * (n % 2 == 0 ? 1 : x);
  }
}
