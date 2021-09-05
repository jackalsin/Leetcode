package airbnb._759_Employee_Free_Time;

import definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/4/2021
 */
public final class SolutionII implements Solution {

  @Override
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final List<Integer> starts = new ArrayList<>(),
        ends = new ArrayList<>();
    for (final List<Interval> sche : schedule) {
      for (final Interval s : sche) {
        starts.add(s.start);
        ends.add(s.end);
      }
    } // end of for schedule
    Collections.sort(starts);
    Collections.sort(ends);
    final List<Interval> result = new ArrayList<>();
    for (int i = 0; i < ends.size() - 1; ++i) {
      final int prevEnd = ends.get(i), start = starts.get(i + 1);
      if (prevEnd < start) {
        result.add(new Interval(prevEnd, start));
      }
    }
    return result;
  }

  @Override
  public int[][] employeeFreeTime(int[][][] schedule) {
    final List<List<Interval>> input = new ArrayList<>();
    for (final int[][] sche : schedule) {
      final List<Interval> line = new ArrayList<>();
      for (final int[] sc : sche) {
        line.add(new Interval(sc[0], sc[1]));
      }
      input.add(line);
    }
    final List<Interval> result = employeeFreeTime(input);
    assert result != null;
    return result.stream().map(x -> new int[]{x.start, x.end}).toArray(int[][]::new);
  }

}
