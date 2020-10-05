package _0951_1000._983_Minimum_Cost_For_Tickets;

import java.util.Arrays;

public class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    final int[] dp = new int[days.length + 1];
    final int[] costDays = {1, 7, 30};
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < days.length; i++) {
      if (dp[i + 1] == Integer.MAX_VALUE) {
        dp[i + 1] = dp[i] + costs[0];
      }
      for (int costIndex = 0; costIndex < costDays.length; costIndex++) {
        for (int j = i; j < days.length; j++) {
          if (days[j] < days[i] + costDays[costIndex]) {
            dp[j + 1] = Math.min(dp[i] + costs[costIndex], dp[j + 1]);
          } else break;
        } // end of j
      }
    }
    return dp[dp.length - 1];
  }
}

