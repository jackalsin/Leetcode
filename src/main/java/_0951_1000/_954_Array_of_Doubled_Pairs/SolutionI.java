package _0951_1000._954_Array_of_Doubled_Pairs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canReorderDoubled(int[] A) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (final int a : A) {
      counts.put(a, counts.getOrDefault(a, 0) + 1);
    }
    final Queue<Integer> keySet = new PriorityQueue<>((x, y) -> Integer.compare(Math.abs(x), Math.abs(y)));
    keySet.addAll(counts.keySet());
    while (!keySet.isEmpty()) {
      final int key = keySet.remove(),
          keyCount = counts.getOrDefault(key, 0);
//      System.out.println(key);
      if (keyCount == 0) continue;
      final int target = key * 2;
      final int expectedCount = keyCount,
          actualCount = counts.getOrDefault(target, 0);
      if (expectedCount > actualCount) {
        return false;
      } else {
        if (expectedCount < actualCount) {
          counts.put(target, -expectedCount + actualCount);
        } else {
          counts.remove(target);
        }
        counts.remove(key);
      }
    }
//    System.out.println(counts);
    return counts.isEmpty();
  }
}
