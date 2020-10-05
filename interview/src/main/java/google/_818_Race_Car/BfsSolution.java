package google._818_Race_Car;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/8/2020
 */
public final class BfsSolution implements Solution {
  private final Set<String> visited = new HashSet<>();

  public int racecar(int target) {
    if (target == 0) {
      return 0;
    }
    final int[] start = {0, 1};
    final String startKey = getKey(0, 1);
    final Queue<int[]> q = new ArrayDeque<>() {{
      add(start);
    }};
    visited.add(startKey);
    int step = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      step++;
      for (int i = 0; i < size; ++i) {
        final int[] toRemove = q.remove();
        // use A
        final int[] accelerate = {toRemove[0] + toRemove[1], toRemove[1] * 2};
        if (accelerate[0] == target) {
          return step;
        }
        final String nextAccelerateKey = getKey(accelerate[0], accelerate[1]);
        if (visited.add(nextAccelerateKey) && isInRange(accelerate[0], target)) {
          q.add(accelerate);
        }
        final int[] reverse = {toRemove[0], toRemove[1] > 0 ? -1 : 1};
        final String nextReverseKey = getKey(reverse[0], reverse[1]);
        if (reverse[0] == target) {
          return step;
        }
        if (visited.add(nextReverseKey) && isInRange(reverse[0], target)) {
          q.add(reverse);
        }
      }
    }
    return 0;
  }

  static String getKey(final int pos, final int speed) {
    return pos + " " + speed;
  }

  private static boolean isInRange(final long val, final long target) {
    return 0 <= val && val <= target * 2;
  }
}
