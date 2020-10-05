package _0401_0450._447_Number_of_Boomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numberOfBoomerangs(int[][] points) {
    int count = 0;
    for (int i = 0; i < points.length; i++) {
      Map<Long, Integer> distance = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j) continue;
        long curDis = getDistance(points[i], points[j]);
        distance.put(curDis, distance.getOrDefault(curDis, 0) + 1);
      }
      for (Map.Entry<Long, Integer> entry : distance.entrySet()) {
        count += entry.getValue() * (entry.getValue() - 1);
      }
    }
    return count;
  }

  private long getDistance(final int[] x1, final int[] x2) {
    return (x1[0] - x2[0]) * (x1[0] - x2[0]) + (x2[1] - x1[1]) * (x2[1] - x1[1]);
  }
}
