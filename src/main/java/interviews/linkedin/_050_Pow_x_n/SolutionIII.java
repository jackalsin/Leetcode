package interviews.linkedin._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIII implements Solution {
  @Override
  public double myPow(double x, int n) {
    long nLong = (long) n;
    final Map<Long, Double> timesToVal = new HashMap<>();
    if (n < 0) {
      return 1d / myPow(timesToVal, x, -nLong);
    } else if (n == 0) {
      return x == 0 ? 0 : 1;
    }
    return myPow(timesToVal, x, nLong);
  }

  public static double myPow(Map<Long, Double> timesToVal, double x, long n) {
    if (timesToVal.containsKey(n)) {
      return timesToVal.get(n);
    }
    if (n == 1) {
      return x;
    }
    final double halfVal = myPow(timesToVal, x, n / 2);
    return halfVal * halfVal * (n % 2 == 1 ? x : 1);
  }
}
