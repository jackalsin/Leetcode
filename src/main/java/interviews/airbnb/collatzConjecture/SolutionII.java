package interviews.airbnb.collatzConjecture;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class SolutionII implements Solution {
  private final Map<Integer, Integer> steps = new HashMap<>();

  @Override
  public int findTheLongestStep(int num) {
    if (num <= 0) {
      throw new IllegalArgumentException("num cannot be non-negative, but num = " + num);
    }
    int max = 0;
    for (int i = 1; i < num; i++) {
      final int cur = getSteps(i);
      max = Math.max(cur, max);
    }
    return max;
  }

  private int getSteps(final int n) {
    if (n == 1) {
      return 0;
    }
    if (steps.containsKey(n)) {
      return steps.get(n);
    }
    final int cur = 1 + ((n % 2 == 0) ? (getSteps(n / 2)) : (getSteps(3 * n + 1)));
    steps.put(n, cur);
    return cur;
  }
}
