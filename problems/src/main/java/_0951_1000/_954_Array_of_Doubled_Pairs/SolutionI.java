package _0951_1000._954_Array_of_Doubled_Pairs;

import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canReorderDoubled(int[] A) {
    final TreeMap<Integer, Integer> counts = new TreeMap<>();
    for (final int a : A) {
      counts.put(a, counts.getOrDefault(a, 0) + 1);
    }
    for (final var e : counts.entrySet()) {
      final int key = e.getKey(), count = e.getValue();
      if (count == 0) {
        continue;
      }
      final int target = key < 0 ? key / 2 : key * 2,
          actualCount = counts.getOrDefault(target, 0);
      if (key < 0 && key % 2 != 0 || actualCount < count) {
        return false;
      }
      counts.put(target, actualCount - count);
    }
    return true;
  }
}
