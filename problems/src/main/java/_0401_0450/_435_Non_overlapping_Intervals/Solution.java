package _0401_0450._435_Non_overlapping_Intervals;

import definition.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  /**
   * Time complexity: O(NlogN)
   * <p>
   * 18 / 18 test cases passed.
   * Status: Accepted
   * Runtime: 9 ms
   * Submitted: 0 minutes ago
   *
   * @param intervals
   * @return
   */
  public int eraseOverlapIntervals(Interval[] intervals) {
    /*
     * Proof:
     * If one tasks end earlier, choose it, so there can be more task scheduled.
     */
    if (intervals.length == 0) return 0;

    Arrays.sort(intervals, new Comparator<>() {
      @Override
      public int compare(Interval i, Interval j) {
        return Integer.compare(i.end, j.end);
      }
    });

    int count = 1, end = intervals[0].end;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start >= end) {
        end = intervals[i].end;
        count++;
      }
    }
    return intervals.length - count;
  }
}
