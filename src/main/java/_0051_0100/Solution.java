package _0051_0100;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public class Solution {

  public boolean canAttendMeeting(final int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return true;
    }
    Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
    Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
    // java contract Integer.compare(a,b), a - b
    for (int i = 1; i < intervals.length; ++i) {
      final int[] cur = intervals[i], prev = intervals[i - 1];
      if (cur[0] >= prev[1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    final int[][] input = new int[][]{{0, 30}, {5, 10}, {15, 20}};
    // assert solution.canAttendMeeting(input) == false;
    // final int [][] input2 = new int[][]  {{5, 8}, {9, 15}};
    // assert solution.canAttendMeeting(input2);

    solution.minRoomsNeeded(input);
  }

  // {{0, 30}, {5, 10}, {15, 20}}
  public int minRoomsNeeded(final int[][] intervals) {
    if (intervals == null) {
      return 0;
    }
    final int[] starts = new int[intervals.length],
        ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }

    int min = 0, curRooms = 0;
    for (int endIndex = 0, startIndex = 0; endIndex < ends.length && startIndex < starts.length; ) {
      final int end = ends[endIndex], start = starts[startIndex];
      if (end >= start) { // TODO: == ???????????????????????  end = 10, start == 0, when time = 10,
        curRooms++;
        min = Math.max(min, curRooms); // make
        startIndex++;
      } else { // end 5, start 15, move end
        curRooms--;
        endIndex++;
      }
    }
    return min;
  }

}
