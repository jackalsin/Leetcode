package airbnb._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/13/2019.
 */
public final class SolutionI implements Solution {
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null) {
      throw new NullPointerException();
    }
    final int[] starts = new int[intervals.length],
        ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      final int[] interval = intervals[i];
      starts[i] = interval[0];
      ends[i] = interval[1];
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
