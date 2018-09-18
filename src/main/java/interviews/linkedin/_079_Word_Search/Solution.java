package interviews.linkedin._079_Word_Search;

public class Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (exist(new boolean[rows][cols], board, word, 0, row, col)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean exist(final boolean[][] visited, char[][] board, String word, int i, int row, int col) {
    if (i == word.length()) {
      return true;
    }
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || word.charAt(i) != board[row][col]) {
      return false;
    }

    visited[row][col] = true;
    boolean res = false;
    for (final int[] dir : DIRS) {
      res |= exist(visited, board, word, i + 1, row + dir[0], col + dir[1]);
      if (res) break;
    }
    visited[row][col] = false;
    return res;
  }

}
