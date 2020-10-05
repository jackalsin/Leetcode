package _0901_0950._909_Snakes_and_Ladders;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/15/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 6;

  public int snakesAndLadders(int[][] board) {
    final int rows = board.length, cols = board[0].length;
    final int[] steps = new int[rows * cols + 1];
    Arrays.fill(steps, -1);
    steps[1] = 0;
    final Queue<Integer> q = new ArrayDeque<Integer>() {{
      add(1);
    }};

    while (!q.isEmpty()) {
      final int id = q.remove();
      for (int i = 1; i <= N; ++i) {
        int nextId = i + id;
        if (nextId > rows * cols) continue;
        final int[] next = getIndex(rows, cols, nextId);
        if (board[next[0]][next[1]] != -1) {
          nextId = board[next[0]][next[1]];
        }
        if (nextId == rows * cols) return steps[id] + 1;
        if (steps[nextId] == -1) {
          steps[nextId] = steps[id] + 1;
          q.add(nextId);
        }
      }
    }
//    System.out.println(Arrays.toString(steps));
    return -1;
  }

  static int[] getIndex(final int rows, final int cols, int index) {
    --index;
    int c = index % cols, rDiff = index / cols, r = rows - 1 - rDiff;
    return new int[]{r, rDiff % 2 == 0 ? c : cols - 1 - c};
  }
}
