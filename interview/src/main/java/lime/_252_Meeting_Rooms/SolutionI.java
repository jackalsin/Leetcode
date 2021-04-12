package lime._252_Meeting_Rooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 4/11/2021
 */
public final class SolutionI implements Solution {
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return true;
    }
    Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
    int[] prev = intervals[0];
    for (int i = 1; i < intervals.length; ++i) {
      final int[] cur = intervals[i];
      if (prev[1] > cur[0]) {
        return false;
      }
      prev = cur;
    }
    return true;
  }
}
