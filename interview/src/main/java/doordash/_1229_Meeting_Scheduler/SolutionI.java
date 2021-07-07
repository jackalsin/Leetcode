package doordash._1229_Meeting_Scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/6/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    if (slots1 == null || slots2 == null) return Collections.emptyList();
    final int m = slots1.length, n = slots2.length;
    Arrays.sort(slots1, (a, b) -> Integer.compare(a[1], b[1]));
    Arrays.sort(slots2, (a, b) -> Integer.compare(a[1], b[1]));
    for (int i = 0, j = 0; i < m && j < n; ) {
      final int[] slot1 = slots1[i], slot2 = slots2[j];
      if (slot2[1] < slot1[0]) {
        ++j;
      } else if (slot1[1] < slot2[0]) {
        ++i;
      } else {
        final int start = Math.max(slot1[0], slot2[0]),
            end = Math.min(slot1[1], slot2[1]);
        if (end - start >= duration) {
          return List.of(start, Math.min(end, start + duration));
        }
        if (slot1[1] < slot2[1]) {
          ++i;
        } else {
          ++j;
        }
      }
    }
    return Collections.emptyList();
  }
}
