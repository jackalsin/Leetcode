package doordash._1229_Meeting_Scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class SolutionII implements Solution {
  @Override
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 0, j = 0; i < slots1.length && j < slots2.length; ) {
      final int[] s1 = slots1[i], s2 = slots2[j];
      if (s1[1] < s2[0]) {
        ++i;
      } else if (s2[1] < s1[0]) {
        ++j;
      } else {
        final int start = Math.max(s1[0], s2[0]), end = Math.min(s1[1], s2[1]);
        if (start + duration <= end) {
          return List.of(start, duration + start);
        }
        if (s1[1] <= s2[1]) {
          ++i;
        } else {
          ++j;
        }
      }
    }
    return Collections.emptyList();
  }
}
