package interviews.airbnb.collatzConjecture;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class SolutionII implements Solution {
  private final Map<Long, Integer> cache = new HashMap<>();

  @Override
  public int findTheLongestStep(int num) {
    int max = 0;
    for (int step = 1; step <= num; step++) {
      final int cur = findSteps(step);
      max = Math.max(cur, max);
    }
    return max;
  }

  private int findSteps(long step) {
    if (step < 1) return 0;
    if (step == 1) return 0;
    if (cache.containsKey(step)) {
      return cache.get(step);
    }
    final int res = step % 2 == 0 ? (1 + findSteps(step / 2)) : (1 + findSteps(3 * step + 1));
    cache.put(step, res);
    return res;
  }
}
