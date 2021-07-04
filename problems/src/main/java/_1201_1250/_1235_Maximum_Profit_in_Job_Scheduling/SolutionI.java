package _1201_1250._1235_Maximum_Profit_in_Job_Scheduling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 7/4/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
    final int n = startTime.length;
    final int[][] jobs = new int[n][3];
    final TreeMap<Integer, Integer> endTimeToProfit = new TreeMap<>() {{
      put(0, 0);
    }};
    for (int i = 0; i < n; ++i) {
      jobs[i] = new int[]{startTime[i], endTime[i], profits[i]};
    }
    Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
    for (final int[] job : jobs) {
      final int start = job[0], end = job[1], profit = job[2],
          maxProfitEndHere = endTimeToProfit.floorEntry(start).getValue() + profit;
      endTimeToProfit.put(end, Math.max(maxProfitEndHere, endTimeToProfit.lastEntry().getValue()));
    }
    return endTimeToProfit.lastEntry().getValue();
  }
}
