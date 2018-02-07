package _651_700._699_Falling_Squares;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/6/2018.
 */
public class Solution {
  public List<Integer> fallingSquares(int[][] positions) {
    final List<Integer> result = new ArrayList<>();
    final List<Interval> intervalList = new ArrayList<>();
    int curMax = 0;
    for (final int[] pos : positions) {
      final Interval interval = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
      curMax = Math.max(curMax, getHeight(interval, intervalList));
      intervalList.add(interval);
      result.add(curMax);
    }
    return result;
  }

  private int getHeight(Interval interval, List<Interval> intervalList) {
    int result = interval.height;
    for (Interval curInterval : intervalList) {
      if (interval.start > curInterval.end) {
        continue;
      }
      if (interval.end < curInterval.start) {
        continue;
      }
      result = Math.max(result, curInterval.height + interval.height);
    }
    interval.height = result;

    return result;
  }

  private static final class Interval {
    private int start, end, height;

    public Interval(int start, int end, int height) {
      this.start = start;
      this.end = end;
      this.height = height;
    }
  }
}
