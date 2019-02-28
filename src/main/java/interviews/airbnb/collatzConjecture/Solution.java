package interviews.airbnb.collatzConjecture;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class Solution {

  private final Map<Long, Integer> cache = new HashMap<>();

  public int findTheLongestStep(final int num) {
    if (num < 1) {
      return 0;
    }
    int max = 0;
    for (int i = 1; i < num; i++) {
      int cur = findSteps(i);
      max = Math.max(cur, max);
    }
    return max;
  }

  private int findSteps(long num) {
    assert num >= 1;
    if (num == 1) {
      return 0;
    }
    if (cache.containsKey(num)) {
      return cache.get(num);
    }
    final int res = 1 + findSteps(num % 2 == 0 ? (num / 2) : (num * 3L + 1));
    cache.put(num, res);
    return res;
  }
}
