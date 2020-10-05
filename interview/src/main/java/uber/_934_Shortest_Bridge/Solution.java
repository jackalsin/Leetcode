package uber._934_Shortest_Bridge;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int shortestBridge(int[][] board) {
    if (board == null || board.length == 0) {
      return 0;
    }
    final int rows = board.length, cols = board[0].length;
    final Queue<int[]> q = new ArrayDeque<>();
    final boolean[][] visited = new boolean[rows][cols];
    out:
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (board[row][col] == 1) {
          dfs(board, q, visited, row, col);
          break out;
        }
      }
    }
    int distance = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int[] toRemove = q.remove();
        for (int[] d : DIRS) {
          final int nextRow = toRemove[0] + d[0], nextCol = toRemove[1] + d[1];
          if (!isInRange(rows, cols, nextRow, nextCol) || visited[nextRow][nextCol]) {
            continue;
          }

          if (board[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
            return distance;
          }

          if (!visited[nextRow][nextCol]) {
            q.add(new int[]{nextRow, nextCol});
            visited[nextRow][nextCol] = true;
          }
        }
      }
      distance++;
    }

    // not found
    throw new IllegalArgumentException();
  }

  private static boolean isInRange(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static void dfs(int[][] board, final Queue<int[]> q, boolean[][] visited, int row, int col) {
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || board[row][col] == 0) {
      return;
    }
    q.add(new int[]{row, col});
    visited[row][col] = true;
    dfs(board, q, visited, row + 1, col);
    dfs(board, q, visited, row - 1, col);
    dfs(board, q, visited, row, col + 1);
    dfs(board, q, visited, row, col - 1);
  }
}
