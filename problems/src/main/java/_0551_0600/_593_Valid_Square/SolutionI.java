package _0551_0600._593_Valid_Square;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    if (Arrays.equals(p1, p2) || Arrays.equals(p2, p3) || Arrays.equals(p3, p4)) {
      return false;
    }
    final int[][] input = {p1, p2, p3, p4};
    Arrays.sort(input, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        final int cmp1 = Integer.compare(o1[0], o2[0]);
        if (cmp1 == 0) {
          return Integer.compare(o1[1], o2[1]);
        }
        return cmp1;
      }
    });
//    System.out.println(Arrays.deepToString(input));
    p1 = input[0];
    p2 = input[1];
    p3 = input[2];
    p4 = input[3];
    if (p1[0] + p4[0] != p2[0] + p3[0]) {
      return false;
    }
    if (p1[1] + p4[1] != p2[1] + p3[1]) {
      return false;
    }
    if (distance(p1, p4) != distance(p2, p3)) {
      return false;
    }
    final long left = ((long) p4[1] - p1[1]) * ((long) p2[1] - p3[1]),
        right = ((long) p4[0] - p1[0]) * ((long) p2[0] - p3[0]);
    if (left != -1 * right) {
      return false;
    }
    return true;
  }

  private static long distance(final int[] p, final int[] q) {
    final long x1 = p[0], y1 = p[1], x2 = q[0], y2 = q[1];
    return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
  }
}
