package _1001_1050._1030_Matrix_Cells_in_Distance_Order;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/20/2020
 */
public final class SolutionI implements Solution {

  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };

  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    final Queue<int[]> q = new ArrayDeque<>() {{
      add(new int[]{r0, c0});
    }};
    final Set<Long> visited = new HashSet<>() {{
      add(getKey(r0, c0));
    }};

    final int[][] result = new int[R * C][2];
    int i = 0;
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
//      System.out.println(Arrays.toString(toRemove));
      result[i][0] = toRemove[0];
      result[i][1] = toRemove[1];
      ++i;
      for (final int[] dir : DIRS) {
        final int nextX = dir[0] + toRemove[0], nextY = dir[1] + toRemove[1];
        if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || !visited.add(getKey(nextX, nextY))) continue;
        q.add(new int[]{nextX, nextY});
      }
    }
    return result;
  }

  private static long getKey(final long x, final int y) {
    return (x << 32) | y;
  }
}
