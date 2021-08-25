package airbnb._252_Meeting_Rooms;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/1/2019.
 */
public final class SolutionI implements Solution {
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return true;
    }
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 1; i < intervals.length; i++) {
      final int[] prev = intervals[i - 1];
      if (prev[1] > intervals[i][0]) {
        return false;
      }
    }
    return true;
  }
}
