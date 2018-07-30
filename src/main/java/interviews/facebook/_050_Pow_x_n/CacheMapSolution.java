package interviews.facebook._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

public final class CacheMapSolution implements Solution {
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    } else if (n < 0) {
      if (n == Integer.MIN_VALUE) {
        return 1d / myPow(x, Integer.MAX_VALUE) / x;
      }
      return 1d / myPow(x, -n);
    }

    final Map<Integer, Double> cache = new HashMap<>() {{
      put(0, 1D);
      put(1, x);
    }};

    return myPow(cache, x, n);
  }

  private static double myPow(final Map<Integer, Double> cache, final double x, final int n) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    int i = n % 2;
    final double half = myPow(cache, x, n / 2);
    cache.put(n / 2, x);
    return half * half * (i == 1 ? x : 1);
  }
}
