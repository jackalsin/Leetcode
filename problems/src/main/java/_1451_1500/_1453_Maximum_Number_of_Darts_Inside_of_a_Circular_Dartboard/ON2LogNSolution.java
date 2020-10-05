package _1451_1500._1453_Maximum_Number_of_Darts_Inside_of_a_Circular_Dartboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/31/2020
 */
public final class ON2LogNSolution implements Solution {
  private static final int MAX_POINTS = 500;
  private final double[][] distances = new double[MAX_POINTS][MAX_POINTS];
  private int[][] points;
  private int n;

  /**
   * Time Complexity: O(N^2 * log N)
   * some help link
   * <a href="https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/discuss/636372/JavaC++Python-POJ-1981/549086">python</a>
   * <a href="https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/discuss/636416/c%2B%2B-O(n2logn)-angular-sweep-(with-picture)">picture to explain</a>
   */
  public int numPoints(int[][] points, int r) {
    this.points = points;
    final int n = points.length;
    this.n = n;
    fillDistance(points);
    int res = 0;
    for (int i = 0; i < n; ++i) {
      final int cur = getPointsInside(i, r);
      res = Math.max(res, cur);
    }
    return res;
  }

  private int getPointsInside(final int i, final int r) {
    final List<Pair> angles = new ArrayList<>();
    for (int j = 0; j < n; ++j) {
      if (i != j && distances[i][j] <= 2 * r) {
        final double B = Math.acos(distances[i][j] / (2 * r)),
            A = Math.atan2(points[i][1] - points[j][1], points[i][0] - points[j][0]),
            alpha = A - B,
            beta = A + B;
        angles.add(new Pair(alpha, true));
        angles.add(new Pair(beta, false));
      }
    } // end of j
    angles.sort((a, b) -> {
      final int angleCmp = Double.compare(a.angle, b.angle);
      if (angleCmp != 0) return angleCmp;
      /*这个还是要true先来，比如多个点同时进入，如果乱序的话，可以会miss掉最大值*/
      return -Boolean.compare(a.isEnter, b.isEnter);
    });
    int res = 1, count = 1;
    for (final Pair p : angles) {
      if (p.isEnter) {
        count++;
      } else {
        count--;
      }
      res = Math.max(res, count);
    }
    return res;
  }

  private void fillDistance(final int[][] points) {
    final int n = points.length;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        distances[i][j] = distances[j][i] = distance(points[i], points[j]);
      }
    }
  }

  private static double distance(final int[] p1, final int[] p2) {
    final double x = p1[0] - p2[0], y = p1[1] - p2[1];
    return Math.sqrt(x * x + y * y);
  }

  private static final class Pair {
    private final double angle;
    private final boolean isEnter;

    private Pair(double angle, boolean isEnter) {
      this.angle = angle;
      this.isEnter = isEnter;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "angle=" + angle +
          ", isEnter=" + isEnter +
          '}';
    }
  }
}
