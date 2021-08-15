package _1251_1300._1284_Minimum_Number_of_Flips_to_Convert_Binary_Matrix_to_Zero_Matrix;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 8/14/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int minFlips(int[][] mat) {
    if (mat == null || mat.length == 0) return 0;
    final int rows = mat.length, cols = mat[0].length;
    int state = 0;
    for (int i = rows - 1; i >= 0; --i) {
      for (int j = cols - 1; j >= 0; --j) {
        state = (state << 1) | mat[i][j];
      }
    }
    if (state == 0) return 0;
    final Queue<Integer> q = new ArrayDeque<>();
    q.add(state);
    final Set<Integer> visited = new HashSet<>();
    visited.add(state);
    int step = 1;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int k = 0; k < size; ++k) {
        final int toRemove = q.remove();
        for (int i = 0; i < rows; ++i) {
          for (int j = 0; j < cols; ++j) {
            final int next = flipCross(toRemove, rows, cols, i, j);
            if (next == 0) return step;
            if (visited.add(next)) {
              q.add(next);
            }
          }
        }
      } // end of for loop k
      step++;
    }
    return -1;
  }

  private static int flipCross(int curState, final int rows, final int cols,
                               int i, int j) {
    curState ^= (1 << (cols * i + j));
    if (isInRange(0, i + 1, rows)) curState ^= (1 << (cols * (i + 1) + j));
    if (isInRange(0, i - 1, rows)) curState ^= (1 << (cols * (i - 1) + j));
    if (isInRange(0, j + 1, cols)) curState ^= (1 << (cols * i + j + 1));
    if (isInRange(0, j - 1, cols)) curState ^= (1 << (cols * i + j - 1));
    return curState;
  }

  private static boolean isInRange(final int left, final int c, final int right) {
    return left <= c && c < right;
  }
}
