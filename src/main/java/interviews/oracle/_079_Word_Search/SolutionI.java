package interviews.oracle._079_Word_Search;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
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
        if (search(board, rows, cols, row, col, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean search(final char[][] board, final int rows, final int cols, final int row, final int col,
                                final String word, final int i) {
    if (word.length() == i ) {
      return true;
    }
    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(i)) {
      return false;
    }
    final char chr = board[row][col];
    board[row][col] = VISITED;
    final boolean res = search(board, rows, cols, row + 1, col, word, i + 1)
        || search(board, rows, cols, row - 1, col, word, i + 1)
        || search(board, rows, cols, row, col + 1, word, i + 1)
        || search(board, rows, cols, row, col - 1, word, i + 1);
    board[row][col] = chr;
    return res;
  }
}
