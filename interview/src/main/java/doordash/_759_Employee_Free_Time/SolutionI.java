package doordash._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final List<Interval> result = new ArrayList<>();
    if (schedule == null) return result;
    final int size = getSize(schedule);
    final int[] starts = new int[size], ends = new int[size];
    {
      int i = 0;
      for (final List<Interval> sche : schedule) {
        for (final Interval s : sche) {
          starts[i] = s.start;
          ends[i++] = s.end;
        }
      }
    }

    Arrays.sort(starts);
    Arrays.sort(ends);
    for (int i = 1; i < size; ++i) {
      final int start = starts[i], prevEnd = ends[i - 1];
      if (prevEnd < start) {
        result.add(new Interval(prevEnd, start));
      }
    }

    return result;
  }

  private static int getSize(final List<List<Interval>> schedule) {
    int res = 0;
    for (final List<Interval> sche : schedule) {
      res += sche.size();
    }
    return res;
  }
}
