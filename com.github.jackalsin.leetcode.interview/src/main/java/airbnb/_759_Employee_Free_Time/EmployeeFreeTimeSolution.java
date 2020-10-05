package airbnb._759_Employee_Free_Time;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class EmployeeFreeTimeSolution implements EmployeeFreeTime {

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule, int startTime, int endTime) {
    final int size = getSize(schedule);
    final int[] starts = new int[size], ends = new int[size];
    {
      int i = 0;
      for (final List<Interval> list : schedule) {
        for (final Interval interval : list) {
          starts[i] = interval.start;
          ends[i++] = interval.end;
        }
      }
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    final List<Interval> result = new ArrayList<>();
    if (starts.length == 0) {
      return result;
    }
    if (starts[0] > startTime) {
      result.add(new Interval(startTime, starts[0]));
    }

    for (int endIndex = 0; endIndex < ends.length - 1; endIndex++) {
      if (ends[endIndex] < startTime) continue;
      if (ends[endIndex] >= endTime) break;
      final int curStartTime = Math.max(ends[endIndex], startTime);
      final int curEndTime = Math.min(starts[endIndex + 1], endTime);
      if (curStartTime < curEndTime) {
        result.add(new Interval(curStartTime, curEndTime));
      }
    }
    if (ends[ends.length - 1] < endTime) {
      result.add(new Interval(ends[ends.length - 1], endTime));
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> schedule) {
    int sum = 0;
    for (final List<Interval> sc : schedule) {
      sum += sc.size();
    }
    return sum;
  }
}
