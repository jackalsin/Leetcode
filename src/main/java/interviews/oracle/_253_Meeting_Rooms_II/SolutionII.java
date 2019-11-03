package interviews.oracle._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    final int[] starts = new int[intervals.length],
        ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; ++i) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int max = 1; // init as 1
    for (int startIndex = 1, endIndex = 0, cur = 1; startIndex < intervals.length; ) {
      if (starts[startIndex] < ends[endIndex]) {
        cur++;
        startIndex++;
        max = Math.max(max, cur);
      } else {
        endIndex++;
        cur--;
      }
    }
    return max;
  }
}
