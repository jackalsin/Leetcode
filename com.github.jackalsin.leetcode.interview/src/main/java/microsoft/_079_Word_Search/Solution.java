package microsoft._079_Word_Search;

public class Solution {

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return false;
    }
    if (word.length() == 0) {
      return false;
    }

    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (dfs(board, row, col, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int row, int col, String word, int i) {
    if (i == word.length()) {
      return true;
    }
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      return false;
    }
    if (word.charAt(i) != board[row][col]) {
      return false;
    }
    final char chr = board[row][col];
    board[row][col] = '*';

    final boolean res = dfs(board, row + 1, col, word, i + 1) ||
        dfs(board, row - 1, col, word, i + 1) ||
        dfs(board, row, col + 1, word, i + 1) ||
        dfs(board, row, col - 1, word, i + 1);

    board[row][col] = chr;
    return res;
  }
}
