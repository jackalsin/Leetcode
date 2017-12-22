package _551_600._587_Erect_the_Fence;

import java.util.ArrayList;
import java.util.List;

import utils.Point;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
 */
public class Solution {
  public List<Point> outerTrees(Point[] points) {
    final List<Point> result = new ArrayList<>();
    for (int i = 0; i < Math.min(3, points.length); i++) {
      result.add(points[i]);
    }
    if (points.length <= 3) {
      return result;
    }

    for (int i = 4; i < points.length; i++) {
      for (int start = 0; start < result.size(); start++) {
        final Point left = result.get(start % result.size()),
            right = result.get((start + 1) % result.size()),
            other = result.get((start + 2) % result.size());
        int curSide = side(left, right, points[i]);
        int refSide = side(left, right, other);
        if (curSide * refSide <= 0) {
          result.add((start + 1) % result.size(), points[i]);
          break;
        }
      }
    }

    return result;
  }

  private int side(Point p1, Point p2, Point p) {
    long x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y, x = p.x, y = p.y;
    long sign = (y2 - y1) * (x - x1) + y1 * (x2 - x1);
    return (int) (sign >>> 63);
  }
}
