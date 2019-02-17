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
      for (List<Interval> s : schedule) {
        for (Interval sChild : s) {
          starts[i] = sChild.start;
          ends[i++] = sChild.end;
        }
      }
    }

    Arrays.sort(starts);
    Arrays.sort(ends);
    final List<Interval> result = new ArrayList<>();
    for (int i = 1; i < size; i++) {
      final int curStart = starts[i], prevEnd = ends[i - 1];
      if (prevEnd < curStart) {
        result.add(new Interval(prevEnd, curStart));
      }
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> sche) {
    int result = 0;
    for (List<Interval> i : sche) {
      result += i.size();
    }
    return result;
  }
}
