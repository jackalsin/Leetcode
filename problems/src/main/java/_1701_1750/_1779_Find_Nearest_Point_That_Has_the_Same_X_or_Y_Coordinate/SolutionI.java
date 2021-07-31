package _1701_1750._1779_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate;

public final class SolutionI implements Solution {
  @Override
  public int nearestValidPoint(int x, int y, int[][] points) {
    long minDistance = Long.MAX_VALUE;
    int res = -1;
    for (int i = 0; i < points.length; ++i) {
      final int x1 = points[i][0], y1 = points[i][1];
      if (x1 == x || y == y1) {
        final long dist = getDistance(x, x1, y, y1);
        if (dist < minDistance) {
          res = i;
          minDistance = dist;
        }
      }
    }
    return res;
  }

  private static long getDistance(final int x1, final int x2, final int y1, final int y2) {
    return ((long) Math.abs(x1 - x2)) + Math.abs(y1 - y2);
  }
}
