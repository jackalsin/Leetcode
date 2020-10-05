package _0751_0800._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SeparateSortingSolution implements Solution {
  /**
   * Time Complexity: O(N log(N))
   *
   * @param schedule
   * @return
   */
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    int size = getSize(schedule);
    final int[] starts = new int[size], ends = new int[size];
    {
      int index = 0;
      for (List<Interval> s : schedule) {
        for (Interval i : s) {
          starts[index] = i.start;
          ends[index++] = i.end;
        }
      }
    }
    Arrays.sort(starts);
    Arrays.sort(ends);

    final List<Interval> result = new ArrayList<>();
    for (int i = 1; i < starts.length; i++) {
      final int start = starts[i], preEnd = ends[i - 1];
      if (preEnd < start) {
        result.add(new Interval(preEnd, start));
      }
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> schedule) {
    int res = 0;
    for (List<Interval> sche : schedule) {
      res += sche.size();
    }
    return res;
  }
}
