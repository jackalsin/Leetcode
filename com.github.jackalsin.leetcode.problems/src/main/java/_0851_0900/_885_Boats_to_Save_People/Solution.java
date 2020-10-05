package _0851_0900._885_Boats_to_Save_People;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
  public int numRescueBoats(int[] people, int limit) {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    for (int p : people) {
      treeMap.put(p, treeMap.getOrDefault(p, 0) + 1);
    }

    int count = 0, curBoatWeight = 0, curBoatPeople = 0;

    while (!treeMap.isEmpty()) {
      final Map.Entry<Integer, Integer> weightToCount = treeMap.floorEntry(limit - curBoatWeight);
      if (weightToCount == null || curBoatPeople == 2) {
        count++;
        curBoatWeight = 0;
        curBoatPeople = 0;
      } else {
        if (weightToCount.getValue() == 1) {
          treeMap.remove(weightToCount.getKey());
        } else {
          treeMap.put(weightToCount.getKey(), weightToCount.getValue() - 1);
        }
        curBoatWeight += weightToCount.getKey();
        curBoatPeople++;
      }
    }

    if (curBoatWeight != 0) {
      count++;
    }

    return count;
  }
}
