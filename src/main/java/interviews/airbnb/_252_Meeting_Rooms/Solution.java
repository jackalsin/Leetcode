package interviews.airbnb._252_Meeting_Rooms;

import utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 2/1/2019.
 */
public class Solution {
  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i, Interval j) {
        return Integer.compare(i.start, j.start);
      }
    });

    for (int i = 1; i < intervals.length; i++) {
      final Interval prev = intervals[i - 1], cur = intervals[i];
      if (prev.end > cur.start) {
        return false;
      }
    }
    return true;
  }
}
