package interviews.oracle._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null) {
      return 0;
    }
    final int[] starts = new int[intervals.length],
        ends = new int[intervals.length];
    {
      for (int i = 0; i < intervals.length; ++i) {
        starts[i] = intervals[i][0];
        ends[i] = intervals[i][1];
      }
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int max = 0, count = 0;
    for (int startIndex = 0, endIndex = 0; startIndex < starts.length; ) {
      if (ends[endIndex] > starts[startIndex]) {
        ++count;
        ++startIndex;
        max = Math.max(max, count);
      } else {
        count--;
        endIndex++;
      }
    }
    return max;
  }
}
