package _101_150._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

import utils.Point;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) return 0;
    int max = 1;
    for (int start = 0; start < points.length - 1; start++) {
      Map<Double, Integer> ratioToCounts = new HashMap<>();
      int invalidRatioCounts = 0;
      for (int end = start + 1; end < points.length; end++) {
        Point startPoint = points[start];
        Point endPoint = points[end];
        if(startPoint.x == endPoint.x) {
          invalidRatioCounts++;
          max = Math.max(invalidRatioCounts + 1, max);
        } else {
          double ratio = ((double) startPoint.y - (double) endPoint.y) / ((double) startPoint.x -
              (double) endPoint.y);
          int curCount = ratioToCounts.getOrDefault(ratio, 0) + 1;
          max = Math.max(curCount + 1, max);
          ratioToCounts.put(ratio, curCount);
        }
      }
    }
    return max;
  }



}
