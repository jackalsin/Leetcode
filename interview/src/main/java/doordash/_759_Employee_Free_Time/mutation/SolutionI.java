package doordash._759_Employee_Free_Time.mutation;

import definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Interval> employeeFreeTime(final List<List<Interval>> schedule, final int start, final int end) {
    final List<Integer> starts = new ArrayList<>(), ends = new ArrayList<>();
    {
      for (final List<Interval> sche : schedule) {
        for (final Interval s : sche) {
          if (isInRange(s, start, end)) {
            starts.add(s.start);
            ends.add(s.end);
          }
        }
      }
    } // end {
    Collections.sort(starts);
    Collections.sort(ends);
    final int size = starts.size();
    final List<Interval> result = new ArrayList<>();
    for (int i = 0; i <= size; ++i) {
      final int s = i == size ? end : starts.get(i),
          prevE = i == 0 ? start : ends.get(i - 1);
      if (prevE < s) {
        result.add(new Interval(prevE, s));
      }
    }
    return result;
  }

  private static boolean isInRange(final Interval interval, final int start, final int end) {
    return start <= interval.start && interval.end <= end;
  }

}