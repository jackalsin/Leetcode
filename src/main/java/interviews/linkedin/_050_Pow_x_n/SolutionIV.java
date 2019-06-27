package interviews.linkedin._050_Pow_x_n;

public final class SolutionIV implements Solution {

  /**
   * TODO: redo
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    if (x == 0) {
      return n == 0 ? 1 : 0;
    }
    if (n == Integer.MIN_VALUE) {
      return 1d / x / myPow(x, -(n + 1));
    }
    if (n < 0) {
      return 1d / myPow(x, -n);
    }
    if (n == 0) {
      return 1;
    }
    if (n % 2 == 0) {
      final double half = myPow(x, n / 2);
      return half * half;
    } else {
      final double half = myPow(x, n / 2);
      return half * half * x;
    }
  }
}
