package byteDance._079_Word_Search;

import definition.TwoDimensionArray;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  private static final char VISITED = '#';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (find(board, word, 0, i, j)) {
          TwoDimensionArray.println(board);
          return true;
        }
      }
    }
    return false;
  }

  private static boolean find(final char[][] board, final String word, final int i, final int row, final int col) {
    if (i == word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || word.charAt(i) != board[row][col] || board[row][col] == VISITED) {
      return false;
    }
    board[row][col] = VISITED;
    for (final int[] d : DIRS) {
      final int nextRow = row + d[0], nextCol = col + d[1];
      if (find(board, word, i + 1, nextRow, nextCol)) {
        return true;
      }
    }
    board[row][col] = word.charAt(i);
    return false;
  }
}
