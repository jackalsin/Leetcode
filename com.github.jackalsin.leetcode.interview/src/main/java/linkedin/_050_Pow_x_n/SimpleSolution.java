package linkedin._050_Pow_x_n;

/**
 * 300 / 300 test cases passed. Status: Accepted Runtime: 18 ms
 *
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class SimpleSolution implements Solution {
  @Override
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    long newN = n;
    if (n < 0) {
      x = 1 / x;
      newN = -newN;
    }
    return myPow(x * x, newN / 2) * (n % 2 == 0 ? 1 : x);
  }

  private double myPow(double x, long n) {
    if (n == 0) {
      return 1;
    }
    return myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : x);
  }

}
