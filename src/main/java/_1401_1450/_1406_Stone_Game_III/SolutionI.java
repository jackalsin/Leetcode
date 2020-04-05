package _1401_1450._1406_Stone_Game_III;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionI implements Solution {
  private final Map<LinkedList<Integer>, Long> cache = new HashMap<>();

  public String stoneGameIII(int[] stoneValue) {
    long sum = 0;
    final LinkedList<Integer> values = new LinkedList<>();
    for (int n : stoneValue) {
      values.add(n);
      sum += n;
    }
    final long alice = maxScore(values, sum),
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

  private long maxScore(final LinkedList<Integer> values, final long sum) {
    if (values.isEmpty()) {
      return 0;
    }
    if (cache.containsKey(values)) {
      return cache.get(values);
    }
    long min = Long.MAX_VALUE;
    long removedSum = 0;
    final LinkedList<Integer> next = new LinkedList<>(values);
    for (int i = 0; i < Math.min(3, values.size()); i++) {
      final int toRemove = next.removeFirst();
      removedSum += toRemove;
      final long candidate = maxScore(next, sum - removedSum);
      if (candidate < min) {
        min = candidate;
      }
    }
    final long max = sum - min;
    cache.put(values, max);
    return max;
  }
}
