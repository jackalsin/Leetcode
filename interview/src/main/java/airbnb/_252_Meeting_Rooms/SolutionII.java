package airbnb._252_Meeting_Rooms;

import java.util.Arrays;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class SolutionII implements Solution {

  @Override
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return true;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 1; i < intervals.length; ++i) {
      if (intervals[i - 1][1] > intervals[i][0]) return false;
    }
    return true;
  }
}
