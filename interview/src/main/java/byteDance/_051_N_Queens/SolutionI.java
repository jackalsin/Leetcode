package byteDance._051_N_Queens;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {
  @Override
  public List<List<String>> solveNQueens(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    solve(result, new ArrayList<>(), n, 0, new boolean[n], new boolean[n * 2 - 1], new boolean[n * 2 - 1]);
    return getFormat(n, result);
  }

  private static List<List<String>> getFormat(final int n, final List<List<Integer>> sources) {
    final List<List<String>> result = new ArrayList<>();
    for (final List<Integer> source : sources) {
      final List<String> format = new ArrayList<>();
      for (final int qCol : source) {
        final StringBuilder sb = new StringBuilder();
        sb.append(".".repeat(Math.max(0, qCol)));
        sb.append("Q");
        sb.append(".".repeat(Math.max(0, n - (qCol + 1))));
        format.add(sb.toString());
      } // end of source for loop
      result.add(format);
    }
    return result;
  }

  private static void solve(final List<List<Integer>> result, final List<Integer> cols, final int n, final int row,
                            final boolean[] visitedCols, final boolean[] visitedDiag, final boolean[] visitedAntiDiag) {
    if (row == n) {
      result.add(new ArrayList<>(cols));
      return;
    }

    for (int col = 0; col < n; ++col) {
      if (visitedCols[col] || visitedDiag[row - col + n - 1] || visitedAntiDiag[row + col]) continue;
      visitedCols[col] = true;
      visitedDiag[row - col + n - 1] = true;
      visitedAntiDiag[row + col] = true;
      cols.add(col);
      solve(result, cols, n, row + 1, visitedCols, visitedDiag, visitedAntiDiag);
      cols.remove(cols.size() - 1);
      visitedCols[col] = false;
      visitedDiag[row - col + n - 1] = false;
      visitedAntiDiag[row + col] = false;
    }
  }
}
