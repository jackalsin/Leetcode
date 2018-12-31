package _0751_0800._759_Employee_Free_Time;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SeparateSortingSolution implements Solution {
  /**
   * Time Complexity: O(N log(N))
   *
   * @param schedule
   * @return
   */
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    int size = getSize(schedule);
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

    final List<Interval> result = new ArrayList<>(), jobs = new ArrayList<>();
    if (size == 0) {
      return result;
    }
    Interval curJob = new Interval(starts[0], ends[0]);
    for (int i = 1; i < starts.length; i++) {
      final int start = starts[i], end = ends[i];
      if (start <= curJob.end) {
        curJob.end = Math.max(end, curJob.end);
      } else {
        jobs.add(curJob);
        curJob = new Interval(start, end);
      }
    }
    if (!jobs.isEmpty() && jobs.get(jobs.size() - 1).start != curJob.start) {
      jobs.add(curJob);
    }

    for (int i = 1; i < jobs.size(); i++) {
      result.add(new Interval(jobs.get(i - 1).end, jobs.get(i).start));
    }
    return result;
  }

  private static int getSize(final List<List<Interval>> schedule) {
    int res = 0;
    for (List<Interval> sche : schedule) {
      res += sche.size();
    }
    return res;
  }
}
