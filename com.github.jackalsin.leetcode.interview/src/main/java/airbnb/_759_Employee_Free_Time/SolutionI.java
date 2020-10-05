package airbnb._759_Employee_Free_Time;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
public final class SolutionI implements Solution {
  @Override
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    return employeeFreeTime(schedule, 0, Integer.MAX_VALUE);
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule, final int startTime, final int endTime) {
    final int total = getSize(schedule);
    final int[] starts = new int[total], ends = new int[total];
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
    //[1, 3, 5, 6]
    //[2, 4, 6, 9]
    final List<Interval> result = new ArrayList<>();
    for (int endIndex = 0; endIndex < ends.length - 1; endIndex++) {
      final int start = starts[endIndex + 1], end = ends[endIndex];
      if (end < startTime) continue;
      if (start >= endTime) break;
      if (end < start) {
        result.add(new Interval(end, start));
      }
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> schedule) {
    int sum = 0;
    for (final List<Interval> s : schedule) {
      sum += s.size();
    }
    return sum;
  }

  @Override
  public int[][] employeeFreeTime(int[][][] schedule) {
    final int total = getSize(schedule);
    final int[] starts = new int[total],
        ends = new int[total];
    {
      int i = 0;
      for (final int[][] sche : schedule) {
        for (final int[] interval : sche) {
          starts[i] = interval[0];
          ends[i++] = interval[1];
        }
      }
      Arrays.sort(starts);
      Arrays.sort(ends);
    }
    final List<int[]> result = new ArrayList<>();
    for (int i = 0; i < total - 1; i++) {
      if (ends[i] < starts[i + 1]) {
        result.add(new int[]{ends[i], starts[i + 1]});
      }
    }
    return result.toArray(new int[0][]);
  }

  private static int getSize(final int[][][] schedule) {
    int sum = 0;
    for (final int[][] sche : schedule) {
      sum += sche.length;
    }
    return sum;
  }
}
