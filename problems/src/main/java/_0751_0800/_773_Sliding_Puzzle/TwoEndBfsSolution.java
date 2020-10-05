package _0751_0800._773_Sliding_Puzzle;

import java.util.HashSet;
import java.util.Set;

public final class TwoEndBfsSolution implements Solution {
  private static final int ROWS = 2, COLS = 3;
  private static final String TARGET = "123450";
  private static int[] DIRS = {1, -1, 3, -3};

  public int slidingPuzzle(int[][] board) {
    if (board == null || board.length == 0) {
      return -1;
    }
    final String original = getBoardString(board);
    if (TARGET.equals(original)) {
      return 0;
    }
    Set<String> begin = new HashSet<>(), end = new HashSet<>();
    final Set<String> visited = new HashSet<>();
    begin.add(original);
    end.add(TARGET);
    int steps = 0;
    while (!begin.isEmpty() || !end.isEmpty()) {
      final Set<String> next = new HashSet<>();
      for (String s : begin) {

        final char[] chars = s.toCharArray();
        final int i = s.indexOf('0');
        for (int d : DIRS) {
          final int j = i + d;
          if (j < 0 || j >= ROWS * COLS
              || (j % COLS == 0 && i % COLS == COLS - 1)
              || (j % COLS == COLS - 1 && i % COLS == 0)) {
            continue;
          }
          swap(chars, i, j);
          final String nextStr = String.valueOf(chars);
          if (end.contains(nextStr)) {
            return steps + 1;
          }
          if (visited.add(nextStr)) {
            next.add(nextStr);
          }
          swap(chars, i, j);
        }
      } // end of for begin
      begin = next;
      steps++;

      { // swap the begin
        if (!end.isEmpty()) {
          final Set<String> tmp = begin;
          begin = end;
          end = tmp;
        }
      }
    }
    return -1;
  }

  private static void swap(final char[] chars, final int i, final int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

  private static String getBoardString(final int[][] board) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        sb.append(board[i][j]);
      }
    }
    return sb.toString();
  }
}
