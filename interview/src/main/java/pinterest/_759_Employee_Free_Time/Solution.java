package pinterest._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final List<Interval> sortedIntervals = new ArrayList<>();
    for (final List<Interval> e : schedule) {
      sortedIntervals.addAll(e);
    }
    Collections.sort(sortedIntervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });

    Interval candidate = sortedIntervals.get(0);
    final List<Interval> result = new ArrayList<>();
    for (Interval i : sortedIntervals) {
      if (candidate.end < i.start) {
        result.add(new Interval(candidate.end, i.start));
        candidate = i;
      } else {
        candidate.end = Math.max(i.end, candidate.end);
      }
    }
    return result;
  }

}
