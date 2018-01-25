package interviews.google.geo;

import utils.Point;

/**
 * @author jacka
 * @version 1.0 on 1/24/2018.
 */
public final class SegmentCross {
  /**
   * 判断线段是否相交
   */
  public boolean isCross(Point p1, Point p2, Point q1, Point q2) {
    long q1P = cross(p1, p2, q1), q2P = cross(p1, p2, q2);
    long p1Q = cross(q1, q2, p1), p2Q = cross(q1, q2, q2);
    if ((q1P * q2P == 0) && (p1Q * p2Q == 0)) {
      return isInBetween(p1, p2, q1) || isInBetween(p1, p2, q2);
    } else {
      return (q1P * q2P <= 0) && (p1Q * p2Q <= 0);
    }
  }

  private boolean isInBetween(Point p1, Point p2, Point q2) {
    return p1.x <= q2.x && q2.x <= p2.x;
  }

  private long cross(Point q1, Point q2, Point p1) {
    long x1 = q2.x - q1.x, y1 = q2.y - q1.y, x2 = p1.x - q1.x, y2 = p1.y - q1.y;
    long res = x1 * y2 - x2 * y1;
    return (res & 0X8000_0000_0000_0000L) >>> 63;
  }

}
