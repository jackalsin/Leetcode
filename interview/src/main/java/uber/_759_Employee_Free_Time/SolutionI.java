package uber._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolutionI implements Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final int size = getSize(schedule);
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
