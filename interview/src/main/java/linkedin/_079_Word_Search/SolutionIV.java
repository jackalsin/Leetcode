package linkedin._079_Word_Search;

/**
 * @author jacka
 * @version 1.0 on 10/4/2019
 */
public final class SolutionIV implements Solution {
  private static final char VISITED = '#';

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (dfs(board, rows, cols, row, col, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(final char[][] board, final int rows, final int cols, final int row, final int col,
                      final String word, int start) {
    if (start == word.length()) {
      return true;
    }
    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(start)) {
      return false;
    }
    final char oldChar = board[row][col];
    board[row][col] = VISITED;
    final boolean result =
        dfs(board, rows, cols, row + 1, col, word, start + 1)
            || dfs(board, rows, cols, row - 1, col, word, start + 1)
            || dfs(board, rows, cols, row, col + 1, word, start + 1)
            || dfs(board, rows, cols, row, col - 1, word, start + 1);
    board[row][col] = oldChar;
    return result;
  }
}
