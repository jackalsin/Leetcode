package _1401_1450._1406_Stone_Game_III;


import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionII implements Solution {
  private final Map<Integer, Long> cache = new HashMap<>();

  public String stoneGameIII(int[] stoneValue) {
    long sum = 0;
    for (int n : stoneValue) {
      sum += n;
    }
    final long alice = maxScore(stoneValue, sum, 0),
        bob = sum - alice;
//    System.out.println(cache);
//    System.out.println(alice);
    if (alice * 2 == sum) {
      return "Tie";
    } else if (alice * 2 > sum) {
      return "Alice";
    } else {
      return "Bob";
    }
  }

  private long maxScore(final int[] values, final long sum, final int cur) {
    if (cur == values.length) {
      return 0;
    }
    if (cache.containsKey(cur)) {
      return cache.get(cur);
    }
    long min = Long.MAX_VALUE;
    long removedSum = 0;
    for (int i = 0; i < 3 && cur + i < values.length; i++) {
      final int toRemove = values[cur + i];
      removedSum += toRemove;
      final long candidate = maxScore(values, sum - removedSum, cur + i + 1);
      if (candidate < min) {
        min = candidate;
      }
    }
    final long max = sum - min;
    cache.put(cur, max);
    return max;
  }
}
