package _1901_1950._1922_Count_Good_Numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private final Map<Long, Integer> cache = new HashMap<>();

  public int countGoodNumbers(long n) {
    if (n % 2 == 1) return (int) ((power20((n - 1) / 2)) * 5L % MOD);
    return power20(n / 2);
  }

  private int power20(final long n) {
    if (n == 0) return 1;
    if (n == 1) return 20;
    if (cache.containsKey(n)) return cache.get(n);
    int half = power20(n / 2);
    int res = (int) (((long) half * half) % MOD);
    if (n % 2 == 1) res = (int) (res * 20L % MOD);
    cache.put(n, res);
    return res;
  }
}
