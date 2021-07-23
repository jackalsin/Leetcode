package doordash._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final List<Integer> starts = new ArrayList<>(),
        ends = new ArrayList<>();
    for (final List<Interval> sche : schedule) {
      for (final Interval s : sche) {
        starts.add(s.start);
        ends.add(s.end);
      }
    }
    Collections.sort(starts);
    Collections.sort(ends);
    final List<Interval> result = new ArrayList<>();
    for (int i = 1; i < starts.size(); ++i) {
      final int prevEnd = ends.get(i - 1), start = starts.get(i);
      if (prevEnd < start) {
        result.add(new Interval(prevEnd, start));
      }
    }
    return result;
  }
}
