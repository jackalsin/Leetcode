package linkedin._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/21/2019
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Double> cache = new HashMap<>();

  public double myPow(double x, int n) {
    if (x == 0) {
      return n == 0 ? 1 : 0;
    }
    if (n == 0) {
      return 1;
    }
    if (n == Integer.MIN_VALUE) {
      return 1 / x / myPow(x, -(n + 1));
    }
    if (n < 0) {
      return 1 / myPow(x, -n);
    }
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    if (n == 1) {
      return x;
    }
    final double half = myPow(x, n / 2);
    final double res = half * half * (n % 2 == 0 ? 1 : x);
    cache.put(n, res);
    return res;
  }
}
