package _0801_0850._812_Largest_Triangle_Area;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public double largestTriangleArea(int[][] points) {
    double max = 0;
    final int n = points.length;
    for (int i = 0; i < n; ++i) {
      final double x1 = points[i][0],
          y1 = points[i][1];
      for (int j = 0; j < n; ++j) {
        final double x2 = points[j][0],
            y2 = points[j][1];
        for (int k = 0; k < n; ++k) {
          final double x3 = points[k][0],
              y3 = points[k][1];
          final double cur = 0.5 *
              (x1 * y2 - x3 * y2 - x2 * y1 - x1 * y3 + x3 * y1 + x2 * y3);
          max = Math.max(max, cur);
        }
      }
    }
    return max;
  }
}
