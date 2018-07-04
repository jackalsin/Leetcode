package interviews.microsoft._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }

    // sort the array with end point
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[1], o2[1]);
      }
    });

    int count = 1, arrowPos = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (arrowPos < points[i][0]) {
        count++;
        arrowPos = points[i][1];
      }
    }
    return count;
  }
}
