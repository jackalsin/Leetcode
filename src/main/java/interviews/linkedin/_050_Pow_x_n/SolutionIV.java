package interviews.linkedin._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIV implements Solution {
  @Override
  public double myPow(double x, int n) {
    final Map<Long, Double> cache = new HashMap<>();
    long nLong = (long) n;
    if (n == 0) {
      return x == 0 ? 0 : 1;
    } else if (nLong < 0) {
      nLong = Math.abs(nLong);
      return 1d / myPow(cache, x, nLong);
    }
    return myPow(cache, x, nLong);

  }

  private static double myPow(final Map<Long, Double> cache, double x, long n) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    if (n == 1) {
      return x;
    }
    final double half = myPow(cache, x, n / 2), res = half * half * (n % 2 == 1 ? x : 1);
    cache.put(n, res);
    return res;
  }
}
