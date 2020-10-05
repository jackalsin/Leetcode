package airbnb._253_Meeting_Rooms_II;

import utils.Interval;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/13/2019.
 */
public final class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null) {
      throw new NullPointerException();
    }
    final int[] starts = new int[intervals.length],
        ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      final Interval interval = intervals[i];
      starts[i] = interval.start;
      ends[i] = interval.end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int startIndex = 0, min = 0, maxMin = 0;
    for (int endIndex = 0; endIndex < intervals.length && startIndex < intervals.length; ) {
      final int end = ends[endIndex], start = starts[startIndex];
      if (end > start) {
        min++;
        maxMin = Math.max(min, maxMin);
        startIndex++;
      } else {
        min--;
        endIndex++;
      }
    }
    return maxMin;
  }
}
