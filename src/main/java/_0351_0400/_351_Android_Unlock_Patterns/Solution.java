package _0351_0400._351_Android_Unlock_Patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class Solution {
  private static final int N = 3;
  private int count = 0;
  private int m;
  private int n;

  private static final int[][] DIRS = {
      {0, 0}, {0, 1}
  };

  public int numberOfPatterns(int m, int n) {
    this.m = m;
    this.n = n;
    final boolean[][] board = new boolean[N][N];
    final List<Integer> path = new ArrayList<>();
    for (int[] coordinate : DIRS) {
      final int row = coordinate[0], col = coordinate[1];
      path.add(row * N + col);
      board[row][col] = true;
      count += dfs(0, board, path, row, col) * 4;
      board[row][col] = false;
      path.remove(path.size() - 1);
    }

    final int row = 1, col = 1;
    path.add(row * N + col);
    board[row][col] = true;
    count += dfs(0, board, path, row, col);
    board[row][col] = false;
    path.remove(path.size() - 1);

    return count;
  }

  private int dfs(int count, boolean[][] board, List<Integer> path, int startRow, int startCol) {
    if (path.size() >= m && path.size() <= n) {
      count++;
      if (path.size() == n) {
        return count;
      }
    }

    for (int row = 0; row < N; ++row) {
      for (int col = 0; col < N; ++col) {
        if (!(startCol == col && startRow == row)) {
          if (isValid(board, startRow, startCol, row, col)) {
            path.add(row * N + col);
            board[row][col] = true;
            count = dfs(count, board, path, row, col);
            board[row][col] = false;
            path.remove(path.size() - 1);
          }
        }
      }
    }
    return count;
  }

  private boolean isValid(boolean[][] visited, int startRow, int startCol, int row, int col) {
    if (row >= N || row < 0 || col >= N || col < 0) {
      return false;
    } else if (visited[row][col]) {
      return false;
    } else {
      final int rowBias = Math.abs(startRow - row);
      final int colBias = Math.abs(startCol - col);
      if (rowBias == N - 1 && colBias == N - 1) { //diagonal or anti
        return visited[N / 2][N / 2];
      } else if (rowBias == N - 1) {
        // (0, 2) -> (2, 2) ; or (0, 0) -> (2, 1)
        return (startCol == col && visited[N / 2][col]) || (colBias == 1);
      } else if (colBias == N - 1) {
        return (startRow == row && visited[row][N / 2]) || (rowBias == 1);
      } else {
        assert rowBias == 1 || colBias == 1;
        return true;
      }
    }
  }

}
