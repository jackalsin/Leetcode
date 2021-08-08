package linkedin._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/25/2019
 */
public final class SolutionV implements Solution {
  private final Map<Integer, Double> cache = new HashMap<>();

  public double myPow(double x, int n) {
    if (n == 0) {
      return x == 0 ? 0 : 1;
    } else if (n == Integer.MIN_VALUE) {
      return 1d / myPow(x, Integer.MAX_VALUE) / x;
    } else if (n < 0) {
      return 1d / myPow(x, -n);
    } else if (n == 1) {
      return x;
    } else {
      if (cache.containsKey(n)) return cache.get(n);
      final double half = myPow(x, n / 2);
      final double res = n % 2 == 1 ? (half * half * x) : (half * half);
      cache.put(n, res);
      return res;
    }
  }
}
