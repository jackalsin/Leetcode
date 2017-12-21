package _551_600._568_Maximum_Vacation_Days;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public int maxVacationDays(int[][] flights, int[][] days) {
    if (flights == null || flights.length == 0 || flights[0].length == 0) {
      return 0;
    }
    if (days == null || days.length == 0 || days[0].length == 0) {
      return 0;
    }
    final int cities = flights.length, K = days[0].length;
    final int[][] dp = new int[K][cities];
    final Map<Integer, Set<Integer>> incomingFlight = new HashMap<>();
    for (int i = 0; i < cities; i++) {
      for (int j = 0; j < cities; j++) {
        Set<Integer> incoming = incomingFlight.getOrDefault(j, new HashSet<>());
        if (flights[i][j] == 1) incoming.add(i);
        incomingFlight.put(j, incoming);
      }
    }
    dp[0][0] = days[0][0];
    for (int city = 1; city < cities; city++) {
      if (flights[0][city] == 1) {
        dp[0][city] = days[city][0];
      } else {
        dp[0][city] = -1;
      }
    }

    for (int k = 1; k < K; k++) {
      for (int city = 0; city < cities; city++) {
        dp[k][city] = dp[k - 1][city];
        if (dp[k - 1][city] != -1) {
          dp[k][city] += days[city][k];
        }
        final Set<Integer> incomingCities = incomingFlight.get(city);
        for (int in : incomingCities) {
          if (dp[k - 1][in] == -1) continue;
          dp[k][city] = Math.max(dp[k][city], dp[k - 1][in] + days[city][k]);
        }
      }
    }
    int max = 0;
    for (int city = 0; city < cities; city++) {
      max = Math.max(max, dp[K - 1][city]);
    }
//    TwoDimensionArray.display2DimensionArray(dp);
    return max;
  }
}
