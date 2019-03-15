package interviews.airbnb._253_Meeting_Rooms_II;

import utils.Interval;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/13/2019.
 */
public final class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    final int[] starts = new int[intervals.length], ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i].start;
      ends[i] = intervals[i].end;
    }

    Arrays.sort(starts);
    Arrays.sort(ends);
    int min = 0, cur = 0;
    for (int endIndex = 0, startIndex = 0; startIndex < ends.length; ) {
      if (ends[endIndex] > starts[startIndex]) {
        startIndex++;
        min = Math.max(min, ++cur);
      } else {
        cur--;
        endIndex++;
      }
    }
    return min;
  }
}
