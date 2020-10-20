package _1001_1050._1020_Number_of_Enclaves;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author zhixi
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1},
  };
  private static final int VISITED = 2;

  public int numEnclaves(int[][] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final Queue<int[]> q = new ArrayDeque<>();
    final int rows = A.length, cols = A[0].length;
    int one = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (A[i][j] == 1) {
          one++;
          if ((i == 0 || j == 0 || i == rows - 1 || j == cols - 1)) {
            A[i][j] = VISITED;
            q.add(new int[]{i, j});
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
        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || A[nextX][nextY] != 1) continue;
        System.out.println(List.of(nextX, nextY));
        A[nextX][nextY] = VISITED;
        q.add(new int[]{nextX, nextY});
      }
    }
    return one;
  }

}
