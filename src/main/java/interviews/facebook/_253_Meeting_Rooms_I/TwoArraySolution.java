package interviews.facebook._253_Meeting_Rooms_I;

import utils.Interval;

import java.util.Arrays;

public final class TwoArraySolution implements Solution {

  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    final int[] start = new int[intervals.length],
        end = new int[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i].start;
      end[i] = intervals[i].end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int endIndex = 0, max = 0, room = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (start[i] < end[endIndex]) {
        room++;
        max = Math.max(max, room);
      } else {
        room--;
        endIndex++;
        i--;
      }
    }
    return max;
  }

}
