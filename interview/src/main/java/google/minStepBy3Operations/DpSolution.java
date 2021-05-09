package google.minStepBy3Operations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public final class DpSolution implements Solution {
  @Override
  public int minSteps(int num) {
    final Map<Integer, Integer> cache = new HashMap<>();
    return minSteps(cache, num);
  }

  private int minSteps(Map<Integer, Integer> cache, final int num) {
    if (num <= 0) return -1;
    if (num == 1) return 0;
    if (cache.containsKey(num)) return cache.get(num);
    long min = Long.MAX_VALUE;
    final int step1 = minSteps(num / 3);
    if (step1 != -1) min = Math.min(min, 1 + step1);
    final int step2 = minSteps(num / 2);
    if (step2 != -1) min = Math.min(min, 1 + step2);
    final int step3 = minSteps(num - 1);
    if (step3 != -1) min = Math.min(min, 1 + step3);
    int res = min == Long.MAX_VALUE ? -1 : (int) min;
    cache.put(num, res);
    return res;
  }
}
