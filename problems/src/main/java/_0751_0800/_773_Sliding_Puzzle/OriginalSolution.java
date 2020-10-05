package _0751_0800._773_Sliding_Puzzle;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public final class OriginalSolution implements Solution {
  private static final int ROWS = 2, COLS = 3;
  // [0, 1, 2]
  // [3, 4, 5]

  private static final int[][] DIRS = {
      {1, 3},
      {0, 4, 2},
      {1, 5},
      {0, 4},
      {1, 3, 5},
      {2, 4},
  };

  /**
   * Runtime: 11 ms,
   * faster than 96.65% of Java online submissions for Sliding Puzzle.
   *
   * @param board
   * @return
   */
  public int slidingPuzzle(int[][] board) {
    final String target = "123450", src = get(board);
    final Set<String> visited = new HashSet<>();
    final Queue<String> q = new ArrayDeque<>();
    if (src.equals(target)) {
      return 0;
    }
    q.add(src);
    visited.add(src);
    int step = 1;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final String toRemove = q.remove();
        final int zeroIndex = toRemove.indexOf('0');
        for (int k : DIRS[zeroIndex]) {
          final String next = swap(toRemove, zeroIndex, k);
          if (next.equals(target)) {
            return step;
          }
          if (!visited.contains(next)) {
            visited.add(next);
            q.add(next);
          }
        }
      } // end of size
      step++;
    }
    return -1;
  }

  private static String swap(String s, int i, int j) {
    final char[] chars = s.toCharArray();
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
    return String.valueOf(chars);
  }

  private static String get(int[][] board) {
    final StringBuilder sb = new StringBuilder();
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLS; col++) {
        sb.append(board[row][col]);
      }
    }
    return sb.toString();
  }
}
