package interviews.facebook._050_Pow_x_n;

public final class ConstantSpaceSolution implements Solution {
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    } else if (n < 0) {
      if (n == Integer.MIN_VALUE) {
        return 1d / myPow(x, Integer.MAX_VALUE) / x;
      }
      return 1d / myPow(x, -n);
    }
    return myPowHelper(x, n);
  }

  private static double myPowHelper(final double x, final int n) {
    if (n == 1) {
      return x;
    }
    int i = n % 2;
    return myPowHelper(x * x, n / 2) * (i == 1 ? x : 1);
  }
}
