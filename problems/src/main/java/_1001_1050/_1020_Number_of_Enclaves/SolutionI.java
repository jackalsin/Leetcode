package _1001_1050._1020_Number_of_Enclaves;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1},
  };

  public int numEnclaves(int[][] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final Queue<int[]> q = new ArrayDeque<>();
    final Set<Long> visited = new HashSet<>();
    final int rows = A.length, cols = A[0].length;
    int one = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (A[i][j] == 1) {
          one++;
          if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
            if (visited.add(getKey(i, j))) {
              q.add(new int[]{i, j});
            }
          }
        }
      }
    }
//    System.out.println(one);
//    q.stream().forEach(x -> System.out.println(Arrays.toString(x)));
//    System.out.println("after");
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      one--;
      for (final int[] dir : DIRS) {
        final int nextX = dir[0] + toRemove[0], nextY = dir[1] + toRemove[1];
        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || A[nextX][nextY] != 1
            || visited.contains(getKey(nextX, nextY))) continue;
//        System.out.println(List.of(nextX, nextY));
        visited.add(getKey(nextX, nextY));
        q.add(new int[]{nextX, nextY});
      }
    }
    return one;
  }

  private static long getKey(final long row, final int col) {
    return (row << 32) | col;
  }
}
