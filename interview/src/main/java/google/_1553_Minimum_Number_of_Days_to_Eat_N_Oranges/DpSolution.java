package google._1553_Minimum_Number_of_Days_to_Eat_N_Oranges;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public final class DpSolution implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  public int minDays(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (cache.containsKey(n)) return cache.get(n);
    final int res = 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3));
    cache.put(n, res);
    return res;
  }
}
