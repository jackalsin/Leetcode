package lime._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/12/2021
 */
public final class SolutionI implements Solution {
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    final int n = intervals.length;
    final int[] starts = new int[n], ends = new int[n];
    for (int i = 0; i < n; ++i) {
      final int[] cur = intervals[i];
      starts[i] = cur[0];
      ends[i] = cur[1];
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int res = 0;
    for (int startIndex = 0, endIndex = 0, cur = 0; startIndex < n && endIndex < n; ) {
      if (ends[endIndex] > starts[startIndex]) {
        cur++;
        res = Math.max(cur, res);
        startIndex++;
      } else {
        cur--;
        endIndex++;
      }
    }
    return res;
  }
}
