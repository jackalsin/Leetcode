package airbnb._252_Meeting_Rooms;

import definition.Interval;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/1/2019.
 */
public final class Solution {
  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return true;
    }
    Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    for (int i = 1; i < intervals.length; i++) {
      final Interval prev = intervals[i - 1];
      if (prev.end > intervals[i].start) {
        return false;
      }
    }
    return true;
  }
}
