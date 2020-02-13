package interviews.tableau._051_N_Queens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/12/2020
 */
public final class SolutionI implements Solution {
  private static final char Q = 'Q', E = '.';

  public List<List<String>> solveNQueens(int n) {
    final List<List<String>> result = new ArrayList<>();
    final List<Integer> cols = new ArrayList<>();
    dfs(result, cols, n, 0);
    return result;
  }

  private void dfs(final List<List<String>> result, final List<Integer> cols, final int n, final int row) {
    if (n == cols.size()) {
      result.add(getBoard(cols));
      return;
    }
    for (int i = 0; i < n; ++i) {
      cols.add(i);
      if (isValid(n, cols)) {
//        System.out.println(cols);
        dfs(result, cols, n, row + 1);
      }
      cols.remove(cols.size() - 1);
    }
  }

  private static boolean isValid(final int n, final List<Integer> cols) {
    final int col = cols.get(cols.size() - 1), row = cols.size() - 1;
    for (int i = 0; i < cols.size() - 1; ++i) {
      if (cols.get(i) == col) {
        return false;
      }
    }
    for (int srcRow = 0; srcRow < row; ++srcRow) {
      final int srcCol1 = col + (row - srcRow),
          srcCol2 = col - (row - srcRow);
      if (srcCol1 == cols.get(srcRow) || srcCol2 == cols.get(srcRow)) {
        return false;
      }
    }
    return true;
  }

  private static List<String> getBoard(final List<Integer> cols) {
    final int n = cols.size();
    final List<String> result = new ArrayList<>();
    for (int col : cols) {
      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (i == col) {
          sb.append(Q);
        } else {
          sb.append(E);
        }
      }
      result.add(sb.toString());
    }
    return result;
  }
}
