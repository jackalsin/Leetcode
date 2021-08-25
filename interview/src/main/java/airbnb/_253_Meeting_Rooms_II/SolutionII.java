package airbnb._253_Meeting_Rooms_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/13/2019.
 */
public final class SolutionII implements Solution {
  @Override
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return 0;
    final int[] starts = Arrays.stream(intervals).mapToInt(a -> a[0]).sorted().toArray(),
        ends = Arrays.stream(intervals).mapToInt(a -> a[1]).sorted().toArray();
    int max = 0, cur = 0;
    for (int endIndex = 0, startIndex = 0; startIndex < ends.length && endIndex < starts.length; ) {
      final int end = ends[endIndex], start = starts[startIndex];
      if (start < end) {
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
