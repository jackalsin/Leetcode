package _0401_0450._436_Find_Right_Interval;

import utils.Interval;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
  /**
   * Time complexity: O(N log N)
   *
   * @param intervals
   * @return
   */
  public int[] findRightInterval(Interval[] intervals) {
    final TreeMap<Integer, Integer> startToIndex = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      startToIndex.put(intervals[i].start, i);
    }

    final int[] result = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      final Interval curInterval = intervals[i];
      final Map.Entry<Integer, Integer> curResult = startToIndex.ceilingEntry(curInterval.end);
      result[i] = curResult == null ? -1 : curResult.getValue();
    }
    return result;
  }

}
