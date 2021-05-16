package uber._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
public final class SolutionII implements Solution {
  @Override
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    if (schedule == null || schedule.isEmpty()) return Collections.emptyList();
    final int size = getSize(schedule);
    final int[] starts = new int[size], ends = new int[size];
    int index = 0;
    for (final List<Interval> s : schedule) {
      for (final Interval i : s) {
        starts[index] = i.start;
        ends[index++] = i.end;
      }
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    final List<Interval> result = new ArrayList<>();
    for (int i = 1; i < size; ++i) {
      final int prevEnd = ends[i - 1], start = starts[i];
      if (prevEnd < start) result.add(new Interval(prevEnd, start));
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> schedules) {
    return schedules.stream().map(List::size).reduce(Integer::sum).orElse(0);
  }
}
