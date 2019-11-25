package interviews.oracle._051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class SolutionI implements Solution {
  private static final char QUEEN = 'Q',
      DEFAULT = '.';

  public List<List<String>> solveNQueens(int n) {
    final List<List<String>> result = new ArrayList<>();
    if (n <= 0) {
      return result;
    }
    final char[][] board = new char[n][n];
    for (int i = 0; i < n; ++i) {
      Arrays.fill(board[i], DEFAULT);
    }
    solve(result, board, 0);
    return result;
  }

  private static void solve(final List<List<String>> result, final char[][] board, final int row) {
    final int n = board.length;
    if (n == row) {
      result.add(getResult(board));
      return;
    }

    for (int col = 0; col < n; col++) {
      board[row][col] = QUEEN;
      if (isValid(board, row, col)) {
        solve(result, board, row + 1);
      }
      board[row][col] = DEFAULT;
    }
  }

  private static boolean isValid(final char[][] board, final int row, final int col) {
    final int n = board.length;
    for (int i = 0; i < n; ++i) {
      if (row == i) continue;
      if (board[i][col] == QUEEN) return false;
    }
//    for (int i = 0; i < n; ++i) {
//      if (col == i) continue;
//      if (board[row][i] == QUEEN) return false;
//    }

    for (int i = 1; i < n; i++) { // top left
      final int nextRow = row - i, nextCol = col - i;
      if (nextRow < 0 || nextCol < 0) break;
      if (board[nextRow][nextCol] == QUEEN) return false;
    }

    for (int i = 1; i < n; i++) {
      final int nextRow = row - i, nextCol = col + i;
      if (nextRow < 0 || nextCol >= n) break;
      if (board[nextRow][nextCol] == QUEEN) return false;
    }
    return true;
  }

  private static List<String> getResult(final char[][] board) {
    final List<String> result = new ArrayList<>();
    for (final char[] row : board) {
      result.add(String.valueOf(row));
    }
    return result;
  }
}
