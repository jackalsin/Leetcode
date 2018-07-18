package _851_900._871_Minimum_Number_of_Refueling_Stops;

public class DpSolution implements Solution {
  /**
   * @param target
   * @param startFuel
   * @param stations
   * @return
   */
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    final int N = stations.length;
    final int[] maxReach = new int[N + 1];
    maxReach[0] = startFuel;
    for (int i = 0; i < N; i++) { // every station
      for (int stops = i; stops >= 0; stops--) {
        if (maxReach[stops] >= stations[i][0]) {
          maxReach[stops + 1] = Math.max(maxReach[stops + 1], maxReach[stops] + stations[i][1]);
        }
      }
    }
    for (int i = 0; i < maxReach.length; i++) {
      if (maxReach[i] >= target) {
        return i;
      }
    }

    return -1;
  }
}
