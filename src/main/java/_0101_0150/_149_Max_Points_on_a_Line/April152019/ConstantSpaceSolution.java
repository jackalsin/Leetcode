package _0101_0150._149_Max_Points_on_a_Line.April152019;

public final class ConstantSpaceSolution implements Solution {
  @Override
  public int maxPoints(int[][] points) {
    if (points == null) {
      return 0;
    }
    if (points.length < 3) {
      return points.length;
    }
    int max = 2;
    for (int i = 1; i < points.length; i++) {
      int count = 0;
      final long curX = points[i][0], curY = points[i][1],
          prevX = points[i - 1][0], prevY = points[i - 1][1],
          deltaX = curX - prevX, deltaY = curY - prevY;
      if (deltaX == 0 && deltaY == 0) {
        for (int[] point : points) {
          if (point[0] == curX && point[1] == curY) {
            count++;
          }
        }
      } else {
        for (final int[] point : points) {
          if ((point[0] - curX) * deltaY == deltaX * (point[1] - curY)) {
            count++;
          }
        }
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
