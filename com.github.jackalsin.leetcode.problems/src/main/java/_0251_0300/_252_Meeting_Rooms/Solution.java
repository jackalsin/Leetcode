package _0251_0300._252_Meeting_Rooms;

import utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public final class Solution {
  /**
   * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
   * For example,
   * Given [[0, 30],[5, 10],[15, 20]],
   * return false.
   *
   * @param intervals
   * @return
   */
  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });

    for (int i = 1; i < intervals.length; i++) {
      final Interval cur = intervals[i], prev = intervals[i - 1];
      if (prev.end > cur.start) {
        return false;
      }
    }
    return true;
  }
}