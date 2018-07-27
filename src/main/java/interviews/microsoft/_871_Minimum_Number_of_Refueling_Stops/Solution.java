package interviews.microsoft._871_Minimum_Number_of_Refueling_Stops;

public class Solution {

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    final int[] dp = new int[stations.length + 1];
    dp[0] = startFuel;
    for (int[] station : stations) {
      for (int i = stations.length; i >= 1; i--) {
        if (dp[i - 1] >= station[0]) {
          dp[i] = Math.max(dp[i - 1] + station[1], dp[i]);
        }
      }
    }


    for (int i = 0; i <= stations.length; i++) {
      if (dp[i] >= target) {
        return i;
      }
    }

    return -1;
  }
}
