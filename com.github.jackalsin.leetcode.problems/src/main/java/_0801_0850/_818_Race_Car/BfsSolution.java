package _0801_0850._818_Race_Car;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public final class BfsSolution implements Solution {

  public int racecar(int target) {
    assert 1 <= target && target <= 10000;
    final Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0, 1});
    final Set<String> visited = new HashSet<>();
    visited.add(getKey(0, 1));
    int level = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int[] toRemove = q.remove();
        final int pos = toRemove[0], speed = toRemove[1];
        if (pos == target) {
          return level;
        }

        // continue positive
        final int[] nextAccelerate = {pos + speed, speed * 2};
        if (!visited.contains(getKey(nextAccelerate[0], nextAccelerate[1]))
            && nextAccelerate[0] > 0 && nextAccelerate[0] < 2 * target) {
          q.add(nextAccelerate);
          visited.add(getKey(nextAccelerate[0], nextAccelerate[1]));
        }
        final int[] nextReverse = {pos, speed > 0 ? -1 : 1};
        if (!visited.contains(getKey(nextReverse[0], nextReverse[1]))
            && nextReverse[0] > 0 && nextReverse[0] < 2 * target) {
          q.add(nextReverse);
          visited.add(getKey(nextReverse[0], nextReverse[1]));
        }
      }
      level++;
    }
    return -1; // should never reachable
  }

  private static String getKey(int pos, int speed) {
    return pos + " " + speed;
  }


}
