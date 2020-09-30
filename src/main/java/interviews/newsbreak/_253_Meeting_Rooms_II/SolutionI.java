package interviews.newsbreak._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/30/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    final int n = intervals.length;
    final int[] starts = new int[n], ends = new int[n];
    for (int i = 0; i < n; ++i) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int max = 0;
    for (int startIndex = 0, endIndex = 0, cur = 0; startIndex < n && endIndex < n; ) {
      if (starts[startIndex] < ends[endIndex]) {
        cur++;
        max = Math.max(max, cur);
        startIndex++;
      } else {
        cur--;
        endIndex++;
      }
    }
    return max;
  }
}
