package linkedin._079_Word_Search;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionII implements Solution {
  private static final char VISITED = '#';
  private int rows, cols;

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null) {
      return false;
    }
    rows = board.length;
    cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        final boolean res = dfs(board, i, j, word, 0);
        if (res) {
          return res;
        }
      }
    }
    return false;
  }

  private boolean dfs(final char[][] board, final int row, final int col, final String word, final int i) {
    if (i == word.length()) {
      return true;
    }
    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(i)) {
      return false;
    }
    final char chr = board[row][col];
    board[row][col] = VISITED;
    final boolean res = dfs(board, row, col + 1, word, i + 1)
        || dfs(board, row, col - 1, word, i + 1)
        || dfs(board, row - 1, col, word, i + 1)
        || dfs(board, row + 1, col, word, i + 1);
    board[row][col] = chr;
    return res;
  }
}
