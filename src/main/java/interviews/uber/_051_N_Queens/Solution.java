package interviews.uber._051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/12/2018.
 */
public class Solution {
  public List<List<String>> solveNQueens(int n) {
    final List<List<String>> result = new ArrayList<>();
    final char[][] board = new char[n][n];
    for (final char[] row : board) {
      Arrays.fill(row, '.');
    }
    solve(result, n, board, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    return result;
  }

  private void solve(List<List<String>> result, int n, char[][] board, int row, final boolean[] colVisited,
                     final boolean[] diagVisited, final boolean[] antiDiagVisited) {
    if (row == n) {
      result.add(toBoard(board));
      return;
    }
    for (int col = 0; col < n; col++) {
      if (colVisited[col] || diagVisited[row + col] || antiDiagVisited[row - col + n - 1]) {
        continue;
      }
      colVisited[col] = true;
      diagVisited[row + col] = true;
      antiDiagVisited[row - col + n - 1] = true;
      board[row][col] = 'Q';
      solve(result, n, board, row + 1, colVisited, diagVisited, antiDiagVisited);
      board[row][col] = '.';
      diagVisited[row + col] = false;
      antiDiagVisited[row - col + n - 1] = false;
      colVisited[col] = false;
    }
  }

  private List<String> toBoard(final char[][] board) {
    final List<String> result = new ArrayList<>();
    for (final char[] row : board) {
      result.add(String.valueOf(row));
    }
    return result;
  }

}
