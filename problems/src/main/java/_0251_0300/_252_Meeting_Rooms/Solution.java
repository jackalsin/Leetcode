package _0251_0300._252_Meeting_Rooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public final class Solution {
  /**
   * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
   * determine if a person could attend all meetings.
   * For example,
   * Given [[0, 30],[5, 10],[15, 20]],
   * return false.
   *
   * @param intervals
   * @return
   */
  public boolean canAttendMeetings(final int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });

    for (int i = 1; i < intervals.length; i++) {
      final int[] cur = intervals[i], prev = intervals[i - 1];
      if (prev[1] > cur[0]) {
        return false;
      }
    }
    return true;
  }
}