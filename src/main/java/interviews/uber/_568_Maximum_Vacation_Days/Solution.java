package interviews.uber._568_Maximum_Vacation_Days;

import java.util.Arrays;

public class Solution {
  public int maxVacationDays(int[][] flights, int[][] days) {
    final int N = flights.length, K = days[0].length;
    final int[][] maxVacationDays = new int[K][N];

    for (int k = 0; k < K; k++) {
      Arrays.fill(maxVacationDays[k], -1);
    }

    maxVacationDays[0][0] = 0;
    for (int end = 0; end < N; end++) {
      if (0 == end || flights[0][end] == 1) {
        maxVacationDays[0][end] = days[end][0];
      }
    }

    for (int k = 1; k < K; k++) {
      for (int start = 0; start < N; start++) {
        if (maxVacationDays[k - 1][start] == -1) continue;
        for (int end = 0; end < N; end++) {
          if (start == end || flights[start][end] == 1) {
            maxVacationDays[k][end] = Math.max(maxVacationDays[k][end],
                maxVacationDays[k - 1][start] + days[end][k]);
          }
        }
      }
    }

//    display(maxVacationDays);

    int max = 0;
    for (int i = 0; i < N; i++) {
      max = Math.max(max, maxVacationDays[K - 1][i]);
    }
    return max;
  }
}
