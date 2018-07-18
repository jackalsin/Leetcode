package _851_900._871_Minimum_Number_of_Refueling_Stops;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PqSolution implements Solution {
  /**
   * @param target
   * @param stations
   * @return
   */
  public int minRefuelStops(int target, int curFuel, int[][] stations) {
    int times = 0, prevLoc = 0;
    final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int[] station : stations) {

      final int location = station[0], fuel = station[1];
      curFuel -= (location - prevLoc);
      while (curFuel < 0 && !pq.isEmpty()) {
        curFuel += pq.remove();
        times++;
      }
      if (curFuel < 0) {
        return -1;
      }
      pq.add(fuel);
      prevLoc = location;
    }

    // deal with the (target, 0)
    curFuel -= (target - prevLoc);
    while (curFuel < 0 && !pq.isEmpty()) {
      curFuel += pq.remove();
      times++;
    }
    if (curFuel < 0) {
      return -1;
    }
    return times;
  }
}
