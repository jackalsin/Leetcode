package _0101_0150._149_Max_Points_on_a_Line;

import utils.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) return 0;
    int max = 1;
    for (int start = 0; start < points.length - 1; start++) {
      Map<Long, Integer> ratioToCounts = new HashMap<>();
      int invalidRatioCounts = 0;
      int self = 1;
      for (int end = start + 1; end < points.length; end++) {
        Point startPoint = points[start];
        Point endPoint = points[end];
        if (startPoint.x == endPoint.x) {
          if (startPoint.y == endPoint.y) {
            self++;
            for (Map.Entry<Long, Integer> entry : ratioToCounts.entrySet()) {
              max = Math.max(entry.getValue() + self, max);
            }
          } else {
            invalidRatioCounts++;
          }
          max = Math.max(invalidRatioCounts + self, max);
        } else {
          int deltaY = startPoint.y - endPoint.y;
          int deltaX = startPoint.x - endPoint.x;
          int gcd = gcd(deltaY, deltaX);
          long slope = ((long) (deltaY / gcd) << 32) | (deltaX / gcd);
          int curCount = ratioToCounts.getOrDefault(slope, 0) + 1;
          max = Math.max(curCount + self, max);
          ratioToCounts.put(slope, curCount);
        }
      }
    }
    return max;
  }


  private static int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }
}
