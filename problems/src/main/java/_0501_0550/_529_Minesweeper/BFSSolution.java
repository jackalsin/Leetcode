package _0501_0550._529_Minesweeper;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSSolution implements Solution {
  private static final char MINE = 'M', UNREVEALED_EMPTY = 'E', REVEALED_EMPTY = 'B', REVEALED_MINE = 'X';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
      {-1, 1}, {-1, -1}, {1, 1}, {1, -1}
  };

  /**
   * 54 / 54 test cases passed.
   * Status: Accepted
   * Runtime: 31 ms
   *
   * @param board
   * @param click
   * @return
   */
  public char[][] updateBoard(char[][] board, int[] click) {
    if (board[click[0]][click[1]] == MINE) {
      board[click[0]][click[1]] = REVEALED_MINE;
      return board;
    } else if (board[click[0]][click[1]] != UNREVEALED_EMPTY) {
      return board;
    }
    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(click);
    final Set<List<Integer>> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      final int[] cur = queue.remove();
      final int row = cur[0], col = cur[1];
      updateMineNumber(board, row, col);
      if (Character.isDigit(board[row][col])) {
        continue;
      }
      for (int[] dir : DIRS) {
        final int nextRow = row + dir[0], nextCol = col + dir[1];
        final List<Integer> nextPair = Arrays.asList(nextRow, nextCol);
        if (isValid(board, nextRow, nextCol) && (board[nextRow][nextCol] == UNREVEALED_EMPTY && !visited.contains(nextPair))) {
          queue.add(new int[]{nextRow, nextCol});
          visited.add(nextPair);
        }
      }
    }
    return board;
  }


  private void updateMineNumber(final char[][] board, final int row, final int col) {
    int mines = 0;
    for (final int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (isValid(board, nextRow, nextCol) && board[nextRow][nextCol] == MINE) {
        mines++;
      }
    }
    if (mines > 0) {
      board[row][col] = (char) (mines + '0');
    } else {
      board[row][col] = REVEALED_EMPTY;
    }
  }

  private static boolean isValid(final char[][] board, int row, int col) {
    final int rows = board.length, cols = board[0].length;
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
