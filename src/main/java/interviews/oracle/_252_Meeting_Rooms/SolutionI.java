package interviews.oracle._252_Meeting_Rooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length < 2) {
      return true;
    }
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });

    for (int i = 1; i < intervals.length; ++i) {
      if (intervals[i - 1][1] > intervals[i][0]) {
        return false;
      }
    }
    return true;
  }
}
