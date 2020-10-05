package _0751_0800._773_Sliding_Puzzle;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * This Solution will be more extensible if it's changed the row number
 * and col number
 */
public final class ExtensibleSolution implements Solution {
  private static final int ROWS = 2, COLS = 3;
  private static final String TARGET = "123450";
  private static int[] DIRS = {1, -1, COLS, -COLS};

  /**
   * Time complexity: O( RC *(RC)! )
   * Space Complexity: O(RC * (RC)!)
   *
   * @param board
   * @return
   */
  public int slidingPuzzle(int[][] board) {
    if (board == null || board.length == 0) {
      return -1;
    }
    final String original = getBoardString(board);
    int steps = 0;
    if (TARGET.equals(original)) {
      return 0;
    }
    final Queue<String> queue = new ArrayDeque<>();
    queue.add(original);
    final Set<String> visited = new HashSet<>();
    visited.add(original);
    while (!queue.isEmpty()) {
      for (int size = queue.size(); size > 0; size--) {
        final String toRemove = queue.remove();
        final char[] chars = toRemove.toCharArray();
        final int i = toRemove.indexOf('0');
        for (int d : DIRS) {
          final int j = i + d;
          if (j < 0 || j >= ROWS * COLS
              || (j % COLS == 0 && i % COLS == COLS - 1)
              || (i % COLS == 0 && j % COLS == COLS - 1)) {
            continue;
          }

          swap(chars, i, j);
          final String next = String.valueOf(chars);
          if (TARGET.equals(next)) {
            return steps + 1;
          }
          if (visited.add(next)) {
            queue.add(next);
          }
          swap(chars, i, j);
        }
      }
      steps++;
    }
    return -1;
  }

  private static void swap(final char[] chars, final int i, final int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

  private static String getBoardString(final int[][] board) {
    final StringBuilder sb = new StringBuilder();
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLS; col++) {
        sb.append(board[row][col]);
      }
    }
    return sb.toString();
  }
}
