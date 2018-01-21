package interviews.google._351_Android_Unlock_Patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public final class ReturnCountSolution implements Solution {
  private static final int N = 3;
  private int count = 0;
  private static final int[][] ONE_STEPS = {
      {1, 1}, {0, 1}, {-1, 1},
      {1, 0}, {-1, 0},
      {1, -1}, {0, -1}, {-1, -1}
  };
  private static final int[][] TWO_STEPS = {
      {2, 0}, {-2, 0}, {0, 2}, {0, -2},
      {2, 1}, {-2, 1}, {1, 2}, {1, -2},
      {2, -1}, {-2, -1}, {-1, 2}, {-1, -2},
      {2, 2}, {2, -2}, {-2, 2}, {-2, -2}
  };
  private int m;
  private int n;

  @Override
  public int numberOfPatterns(int m, int n) {
    this.m = m;
    this.n = n;
    List<Integer> path = new ArrayList<>();
    final boolean[][] visited = new boolean[N][N];
    visited[0][0] = true;
    path.add(getVal(0, 0));
    dfs(visited, path, 0, 0);
    path.remove(path.size() - 1);
    int one = count;
    visited[0][0] = false;
    count = 0;

    visited[0][1] = true;
    path.add(getVal(0, 1));
    dfs(visited, path, 0, 1);
    path.remove(path.size() - 1);
    int two = count;
    visited[0][1] = false;
    count = 0;

    visited[1][1] = true;
    path.add(getVal(1, 1));
    dfs(visited, path, 1, 1);
    path.remove(path.size() - 1);
    int five = count;
    visited[1][1] = false;
    return one * 4 + two * 4 + five;
  }

  private void dfs(final boolean[][] visited, List<Integer> path,
                   int startRow, int startCol) {
    if (path.size() >= m) {
      count++;
      if (path.size() == n) {
        return;
      }
    }

    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {
        if (startCol == col && startRow == row) {
          continue;
        }
        if (isValid(startRow, startCol, row, col, visited)) {
          path.add(getVal(row, col));
          visited[row][col] = true;
          dfs(visited, path, row, col);
          visited[row][col] = false;
          path.remove(path.size() - 1);
        }
      }
    }
  }

  private boolean isValidOneStep(int row, int col, boolean[][] visited) {
    return row >= 0 && row < N && col >= 0 && col < N && !visited[row][col];
  }

  private boolean isValid(final int startRow, final int startCol, int row, int col,
                          boolean[][] visited) {
    if (!isValidOneStep(row, col, visited)) {
      return false;
    }
    int deltaRow = Math.abs(row - startRow), deltaCol = Math.abs(col - startCol);
    if ((deltaCol == 1 && (deltaRow == 0 || deltaRow == 1)) ||
        (deltaRow == 1 && (deltaCol == 0 || deltaCol == 1))) {
      return true;
    }
    if (deltaCol == 1 || deltaRow == 1) {
      return true;
    }
    return visited[(startRow + row) / 2][(startCol + col) / 2];

  }

  private static int getVal(int row, int col) {
    return row * N + col;
  }
}
