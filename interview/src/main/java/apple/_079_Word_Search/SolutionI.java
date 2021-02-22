package apple._079_Word_Search;

/**
 * @author jacka
 * @version 1.0 on 2/21/2021
 */
public final class SolutionI implements Solution {
  private static final char VISITED = '#';

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        final boolean exist = dfs(board, rows, cols, row, col, word, 0);
        if (exist) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(final char[][] board, final int rows, final int cols,
                      final int row, final int col, final String word, final int i) {
    if (i == word.length()) {
      return true;
    }
    if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] == VISITED) {
      return false;
    }
    final char chr = word.charAt(i);
    if (chr != board[row][col]) {
      return false;
    }
    board[row][col] = VISITED;
    final boolean exist = dfs(board, rows, cols, row + 1, col, word, i + 1)
        || dfs(board, rows, cols, row - 1, col, word, i + 1)
        || dfs(board, rows, cols, row, col - 1, word, i + 1)
        || dfs(board, rows, cols, row, col + 1, word, i + 1);
    if (exist) {
      return true;
    }
    board[row][col] = chr;
    return false;
  }
}
