package interviews.airbnb._759_Employee_Free_Time;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
public final class Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final int size = getSize(schedule);
    final int[] starts = new int[size], ends = new int[size];
    {
      int i = 0;
      for (List<Interval> sche : schedule) {
        for (Interval s : sche) {
          starts[i] = s.start;
          ends[i++] = s.end;
        }
      }
    } // end of brace
    Arrays.sort(starts);
    Arrays.sort(ends);
    final List<Interval> result = new ArrayList<>();
    for (int i = 1; i < starts.length; i++) {
      final int prevEnd = ends[i - 1], start = starts[i];
      if (prevEnd < start) {
        result.add(new Interval(prevEnd, start));
      }
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> schedule) {
    int size = 0;
    for (final List<Interval> s : schedule) {
      size += s.size();
    }
    return size;
  }
}
