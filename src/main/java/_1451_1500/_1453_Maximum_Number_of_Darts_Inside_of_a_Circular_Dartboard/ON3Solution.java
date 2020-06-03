package _1451_1500._1453_Maximum_Number_of_Darts_Inside_of_a_Circular_Dartboard;

public final class ON3Solution implements Solution {

  /**
   * This is a heuristic bias used for double comparision
   */
  private static final double BIAS = 1E-5;

  public int numPoints(int[][] points, int r) {
    int max = 1;
    for (int i = 0; i < points.length; ++i) {
      for (int j = i + 1; j < points.length; ++j) {
        final double distance = distance(points[i], points[j]);
        if (distance > 2d * r) continue;
        final double[][] centers = getCenters(points[i], points[j], r);
        int count1 = 0, count0 = 0;
        for (int k = 0; k < points.length; ++k) {
          final double d1 = distance(centers[0], points[k]),
              d2 = distance(centers[1], points[k]);
          if (d1 <= r + BIAS) {
            count0++;
            max = Math.max(count0, max);
          }
          if (d2 <= r + BIAS) {
            count1++;
            max = Math.max(count1, max);
          }
        }
//        System.out.println();
      }
    }
    return max;
  }

  private static double[][] getCenters(final int[] p1, final int[] p2, final int r) {
    final double deltaX = p2[0] - p1[0], deltaY = p2[1] - p1[1],
        theta = Math.atan(deltaY / deltaX);
    final double[] mid = {((double) p1[0] + p2[0]) / 2, ((double) p1[1] + p2[1]) / 2};
    final double d = distance(mid, p1), v = Math.sqrt(r * r - d * d);
    return new double[][]{
        {mid[0] + v * Math.sin(theta), mid[1] - v * Math.cos(theta)},
        {mid[0] - v * Math.sin(theta), mid[1] + v * Math.cos(theta)}
    };
  }

  private static double distance(final double[] p1, final int[] p2) {
    final double x = p1[0] - p2[0], y = p1[1] - p2[1];
    return Math.sqrt(x * x + y * y);
  }

  private static double distance(final int[] p1, final int[] p2) {
    final double x = p1[0] - p2[0], y = p1[1] - p2[1];
    return Math.sqrt(x * x + y * y);
  }
}
