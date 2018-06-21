package interviews.linkedin._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

public final class SolutionII implements Solution {
  private final Map<Long, Double> cached = new HashMap<>();

  @Override
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    cached.put(0L, 1d);
    final int sign = n < 0 ? -1 : 1;
    long times = Math.abs((long) n);

    double res = myPow(x, times);
    return sign == 1 ? res : (1d / res);
  }

  private double myPow(final double x, final long times) {
    if (cached.containsKey(times)) {
      return cached.get(times);
    }
    final long half = times / 2;
    final double res = myPow(x, half) * myPow(x, half) * (times % 2 == 0 ? 1 : x);
    cached.put(times, res);
    return res;
  }
}
