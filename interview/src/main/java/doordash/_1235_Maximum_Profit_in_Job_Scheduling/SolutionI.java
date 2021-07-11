package doordash._1235_Maximum_Profit_in_Job_Scheduling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 7/10/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
    assert startTime != null && endTime != null && profits != null;
    final int n = startTime.length;
    final int[][] jobs = new int[n][3];
    for (int i = 0; i < n; ++i) {
      jobs[i] = new int[]{startTime[i], endTime[i], profits[i]};
    }
    Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));
    final TreeMap<Integer, Integer> endToProfit = new TreeMap<>() {{
      put(0, 0);
    }};

    for (final int[] job : jobs) {
      final int start = job[0], end = job[1], profit = job[2];
      final Map.Entry<Integer, Integer> prev = endToProfit.floorEntry(start);
      final int maxProfit = prev.getValue() + profit;
      endToProfit.put(end, Math.max(maxProfit, endToProfit.lastEntry().getValue()));
    }
    return endToProfit.lastEntry().getValue();
  }
}
