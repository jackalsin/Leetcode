package _051_100._052_N_Queens_II;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class BetterSolution {
  private int result = 0;

  public int totalNQueens(int n) {

    final boolean[] colVisited = new boolean[n],
        diagVisited = new boolean[2 * n - 1],
        antiDiagVisited = new boolean[2 * n - 1];
    solve(n, 0, colVisited, diagVisited, antiDiagVisited);
    return result;
  }

  private void solve(
      int n,
      int row,
      boolean[] colVisited,
      boolean[] diagVisited,
      boolean[] antiDiagVisited) {
    if (row == n) {
      result++;
      return;
    }
    for (int col = 0; col < n; col++) {
      if (colVisited[col]) continue;
      if (diagVisited[row + col] || antiDiagVisited[row - col + n - 1]) continue;

      colVisited[col] = true;
      diagVisited[row + col] = true;
      antiDiagVisited[row - col + n - 1] = true;

      solve(n, row + 1, colVisited, diagVisited, antiDiagVisited);

      diagVisited[row + col] = false;
      antiDiagVisited[row - col + n - 1] = false;
      colVisited[col] = false;
    }
  }
}
