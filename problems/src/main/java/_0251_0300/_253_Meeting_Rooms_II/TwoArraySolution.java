package _0251_0300._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public final class TwoArraySolution implements Solution {
  public int minMeetingRooms(final int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    final int[] starts = new int[intervals.length], ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int maxRoom = 0, room = 0;
    for (int startIndex = 0, endIndex = 0; startIndex < intervals.length; startIndex++) {
      if (starts[startIndex] < ends[endIndex]) {
        room++;
        maxRoom = Math.max(maxRoom, room);
      } else {
        endIndex++;
        startIndex--;
        room--;
      }
    }
    return maxRoom;
  }

}
