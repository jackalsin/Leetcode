package interviews.facebook._079_Word_Search;

public class Solution {

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (dfs(board, visited, row, col, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(final char[][] board, final boolean[][] visited, final int startRow,
                             final int startCol, final String word, final int i) {
    if (word.length() == i) {
      return true;
    }
    final int rows = board.length, cols = board[0].length;
    if (startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols
        || word.charAt(i) != board[startRow][startCol] || visited[startRow][startCol]) {
      return false;
    }
    visited[startRow][startCol] = true;
    final boolean res = dfs(board, visited, startRow + 1, startCol, word, i + 1) ||
        dfs(board, visited, startRow - 1, startCol, word, i + 1) ||
        dfs(board, visited, startRow, startCol + 1, word, i + 1) ||
        dfs(board, visited, startRow, startCol - 1, word, i + 1);
    visited[startRow][startCol] = false;
    return res;
  }
}
