package _0851_0900._881_Boats_to_Save_People;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numRescueBoats(int[] people, int limit) {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (final int p : people) {
      treeMap.put(p, treeMap.getOrDefault(p, 0) + 1);
    }
    int result = 0;
    nextBoat:
    while (!treeMap.isEmpty()) {
      result++;
      int remainWeight = limit, remainSeat = 2;
      while (remainWeight > 0 && remainSeat > 0) {
        final Map.Entry<Integer, Integer> e = treeMap.floorEntry(remainWeight);
        if (e == null) {
          continue nextBoat;
        }
        final int weight = e.getKey(), count = e.getValue();
        if (remainWeight >= weight) {
          remainWeight -= weight;
          remainSeat--;
          if (count == 1) {
            treeMap.remove(weight);
          } else {
            treeMap.put(weight, count - 1);
          }
        } else {
          continue nextBoat;
        }
      }
    }
    return result;
  }
}
