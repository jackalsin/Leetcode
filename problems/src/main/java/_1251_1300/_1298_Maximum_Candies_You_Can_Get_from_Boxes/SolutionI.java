package _1251_1300._1298_Maximum_Candies_You_Can_Get_from_Boxes;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 8/14/2021
 */
public final class SolutionI implements Solution {
  private static final int OPEN = 1, CLOSE = 0;

  public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    final Set<Integer> unopenedBoxes = new HashSet<>();
    int res = 0;
    final Queue<Integer> q = new ArrayDeque<>();
    for (int b : initialBoxes) {
      if (status[b] == OPEN) q.add(b);
      else unopenedBoxes.add(b);
    }

    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      res += candies[toRemove];
      // open keys
      for (final int key : keys[toRemove]) {
        if (status[key] == CLOSE) {
          if (unopenedBoxes.remove(key)) q.add(key);
          status[key] = OPEN;
        }
      }

      // add children
      for (final int next : containedBoxes[toRemove]) {
        if (status[next] == OPEN) q.add(next);
        else unopenedBoxes.add(next);
      }
    }
    return res;
  }
}
