package airbnb._130_Surrounded_Regions;

/**
 * @author jacka
 * @version 1.0 on 1/25/2019.
 */
public class Solution {
  private static final char O = 'O', X = 'X', NO_TOUCH = '1';

  public void solve(char[][] board) {
    if (board == null || board.length < 2 || board[0].length < 2) {
      return;
    }

    final int rows = board.length, cols = board[0].length;

    // turn all O to NO_TOUCH
    for (int col = 0; col < cols; col++) {
      dfs(board, 0, col, O, NO_TOUCH);
      dfs(board, rows - 1, col, O, NO_TOUCH);
    }

    for (int row = 0; row < rows; row++) {
      dfs(board, row, 0, O, NO_TOUCH);
      dfs(board, row, cols - 1, O, NO_TOUCH);
    }

    // Turn all the middle O to X
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (board[row][col] == O) {
          board[row][col] = X;
        }
      }
    }

    // turn all NO_TOUCH to o
    for (int col = 0; col < cols; col++) {
      dfs(board, 0, col, NO_TOUCH, O);
      dfs(board, rows - 1, col, NO_TOUCH, O);
    }

    for (int row = 0; row < rows; row++) {
      dfs(board, row, 0, NO_TOUCH, O);
      dfs(board, row, cols - 1, NO_TOUCH, O);
    }
  }

  private static void dfs(final char[][] board, final int row, int col, char src, char target) {
    if (!isValid(board, row, col) || board[row][col] != src) {
      return;
    }
    board[row][col] = target;
    dfs(board, row + 1, col, src, target);
    dfs(board, row - 1, col, src, target);
    dfs(board, row, col + 1, src, target);
    dfs(board, row, col - 1, src, target);
  }

  private static boolean isValid(final char[][] board, final int row, final int col) {
    final int rows = board.length, cols = board[0].length;
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}

