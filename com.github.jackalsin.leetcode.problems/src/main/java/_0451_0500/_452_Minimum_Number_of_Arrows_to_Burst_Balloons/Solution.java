package _0451_0500._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class Solution {

  public int findMinArrowShots(int[][] points) {
    return findMinArrowShotsHelper(points);
//    return findMinArrowShotsTailSolution(points);
  }

  private int findMinArrowShotsTailSolution(int[][] points) {
    if (points == null || points.length == 0 || points[0].length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[1], o2[1]);
      }
    });
    int arrows = 1, leftBoundary = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (leftBoundary < points[i][0]) {
        arrows++;
        leftBoundary = points[i][1];
      }
    }
    return arrows;
  }

  /**
   * 43 / 43 test cases passed. Status: Accepted Runtime: 43 ms
   */
  private int findMinArrowShotsHelper(int[][] points) {
    if (points == null || points.length == 0 || points[0].length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return Integer.compare(o1[1], o2[1]);
        }
        return Integer.compare(o1[0], o2[0]);
      }
    });
    int arrows = 1, rightBoundary = points[0][1];

    for (int i = 1; i < points.length; i++) {
      int[] balloon = points[i];
      if (balloon[0] <= rightBoundary) {
        rightBoundary = Math.min(rightBoundary, balloon[1]);
      } else {
        rightBoundary = balloon[1];
        arrows++;
      }
    }
    return arrows;
  }
}
