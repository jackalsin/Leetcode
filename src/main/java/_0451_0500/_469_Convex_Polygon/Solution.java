package _0451_0500._469_Convex_Polygon;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/22/2017.
 */
public class Solution {
  /**
   * get the cross product of the sequential input edge a, b as tmp, then: if tmp == 0, a -> b 180°
   * on the same line; elif tmp > 0, a -> b clockwise; else tmp < 0, a -> anticlockwise; tmp =
   * (p1[0]-p0[0])(p2[1]-p0[1])-(p2[0]-p0[0])(p1[1]-p0[1])
   */
  public boolean isConvex(List<List<Integer>> points) {
//    return isConvexWithoutCache(points);
    return isConvexFast(points);
  }

  /**
   *
   */
  private boolean isConvexFast(List<List<Integer>> points) {
    if (points.size() <= 2) {
      return false;
    }
    final int len = points.size();
//    long last = 0; // must be long to avoid overflow on the det calculation
    int negativeCounter = 0, positiveCounter = 0;
    for (int i = 0; i < points.size(); i++) {
      List<Integer> point1 = points.get(i % len), point2 = points.get((i + 1) % len), point3 =
          points.get((i + 2) % len);
      long cur = (point2.get(0) - point1.get(0)) * (point3.get(1) - point2.get(1)) - (point2.get
          (1) - point1.get(1)) * (point3.get(0) - point2.get(0));
      if (cur == 0) {
        continue;
      }
      if (cur > 0) {
        positiveCounter++;
      } else {
        negativeCounter++;
      }
      if (negativeCounter * positiveCounter != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * This solution use long multiplication. 54 / 54 test cases passed. Status: Accepted Runtime: 41
   * ms
   */
  private boolean isConvexSlowe(List<List<Integer>> points) {
    if (points.size() <= 2) {
      return false;
    }
    final int len = points.size();
    long last = 0; // must be long to avoid overflow on the det calculation
    for (int i = 0; i < points.size(); i++) {
      List<Integer> point1 = points.get(i % len), point2 = points.get((i + 1) % len), point3 =
          points.get((i + 2) % len);
      long cur = (point2.get(0) - point1.get(0)) * (point3.get(1) - point2.get(1)) - (point2.get
          (1) - point1.get(1)) * (point3.get(0) - point2.get(0));
      if (cur != 0) {
        if (last * cur < 0) {
          return false;
        }
        last = cur;
      }
    }
    return true;
  }

  // Return the cross product AB x BC.
  // The cross product is a vector perpendicular to AB and BC having length |AB| * |BC| * Sin
  // (theta) and
  // with direction given by the right-hand rule. For two vectors in the X-Y plane, the result is a
  // vector with X and Y components 0 so the Z component gives the vector's length and direction.
  private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
    // Get the vectors' coordinates.
    int BAx = Ax - Bx;
    int BAy = Ay - By;
    int BCx = Cx - Bx;
    int BCy = Cy - By;

    // Calculate the Z coordinate of the cross product.
    return (BAx * BCy - BAy * BCx);
  }
}
