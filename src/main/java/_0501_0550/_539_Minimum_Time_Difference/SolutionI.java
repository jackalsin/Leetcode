package _0501_0550._539_Minimum_Time_Difference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/27/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findMinDifference(List<String> timePoints) {
    if (timePoints == null || timePoints.size() < 2) {
      return 0;
    }
    Collections.sort(timePoints);
    final List<Time> times = getTimes(timePoints);
    final int len = timePoints.size();
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= times.size(); ++i) {
      final Time prev = times.get(i - 1), cur = times.get(i % len);
      final int diff = getDiff(cur, prev);
      min = Math.min(diff, min);
    }
    return min;
  }

  private static int getDiff(final Time cur, final Time prev) {
    final int diffHr = cur.hr - prev.hr, diffMin = cur.min - prev.min;
    return (diffHr * 60 + diffMin + 1440) % 1440;
  }

  private static List<Time> getTimes(final List<String> timePoints) {
    final List<Time> result = new ArrayList<>();
    for (final String tp : timePoints) {
      result.add(new Time(tp));
    }
    return result;
  }

  private static final class Time {
    private final int hr, min;

    private Time(final String time) {
      final String[] items = time.split(":");
      hr = Integer.parseInt(items[0]);
      min = Integer.parseInt(items[1]);
    }

    private Time(int hr, int min) {
      this.hr = hr;
      this.min = min;
    }
  }
}
