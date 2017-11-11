package _351_400._391_Perfect_Rectangle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class Solution {

  /**
   * Satisfy 2 conditions,
   *  1) the area of the largest equals the sum
   *  2) all inner corner points  are even
   * @param rectangles
   * @return
   */
  public boolean isRectangleCover(int[][] rectangles) {
    if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) return false;
    int left = Integer.MAX_VALUE;
    int bottom = Integer.MAX_VALUE;
    int top = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;
    Set<Long> usedPoints = new HashSet<>();
    int sum = 0;
    for (final int[] rectangle: rectangles) {
      int curLeft = rectangle[0], curBottom = rectangle[1], curRight = rectangle[2],
          curTop = rectangle[3];
      left = Math.min(left, curLeft);
      right = Math.max(right, curRight);
      top = Math.max(top, curTop);
      bottom = Math.min(bottom, curBottom);

      long leftTop = getPoint(curLeft, curTop);
      long rightBottom= getPoint(curRight, curBottom);
      long leftBottom = getPoint(curLeft, curBottom);
      long rightTop = getPoint(curRight, curTop);

      sum += (curTop - curBottom) * (curRight - curLeft);
      if (!usedPoints.add(leftTop))
        usedPoints.remove(leftTop);
      if (!usedPoints.add(leftBottom))
        usedPoints.remove(leftBottom);
      if (!usedPoints.add(rightTop))
        usedPoints.remove(rightTop);
      if (!usedPoints.add(rightBottom))
        usedPoints.remove(rightBottom);

    }

    return (sum == (right - left) * (top - bottom)) && usedPoints.size() == 4 &&
        (usedPoints.contains(getPoint(left, top)) && usedPoints.contains(getPoint(left, bottom))
            && usedPoints.contains(getPoint(right, top)) && usedPoints.contains(getPoint(right, bottom)));
  }

  static long getPoint(int left, int top) {
    return (long) left << 32 | (top & 0xFFFFFFFFL);
  }

}
