package linkedin._252_Meeting_Rooms;

import utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(final Interval i, final Interval j) {
        return Integer.compare(i.start, j.start);
      }
    });
    for (int i = 0; i < intervals.length - 1; ++i) {
      if (intervals[i].end > intervals[i + 1].start) {
        return false;
      }
    }
    return true;
  }
}
