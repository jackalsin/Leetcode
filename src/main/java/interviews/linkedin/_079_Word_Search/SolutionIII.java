package interviews.linkedin._079_Word_Search;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public final class SolutionIII implements Solution {
  private static final char VISITED = '#';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public boolean exist(char[][] board, String word) {
    if (board == null || word == null || board.length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        final boolean res = dfs(board, word, row, col, 0);
        if (res) return true;
      }
    }
    return false;
  }

  private static boolean dfs(final char[][] board, final String word,
                             final int row, final int col, final int start) {
    if (start == word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || board[row][col] != word.charAt(start)) {
      return false;
    }
    board[row][col] = VISITED;
    final boolean res =
        dfs(board, word, row + 1, col, start + 1) ||
            dfs(board, word, row - 1, col, start + 1) ||
            dfs(board, word, row, col + 1, start + 1) ||
            dfs(board, word, row, col - 1, start + 1);
    board[row][col] = word.charAt(start);
    return res;
  }
}
