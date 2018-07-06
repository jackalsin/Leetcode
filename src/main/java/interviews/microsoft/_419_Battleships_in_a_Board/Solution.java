package interviews.microsoft._419_Battleships_in_a_Board;


import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  private static final char X = 'X', EMPTY = '.';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public int countBattleships(char[][] board) {
    int count = 0, rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (board[row][col] == X) {
          dfs(board, row, col);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(final char[][] board, final int startRow, final int startCol) {
    final int rows = board.length, cols = board[0].length;
    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{startRow, startCol});

    while (!queue.isEmpty()) {
      final int[] remove = queue.remove();
      board[remove[0]][remove[1]] = EMPTY;
      for (int[] dir : DIRS) {
        final int row = remove[0] + dir[0], col = remove[1] + dir[1];
        if (row >= 0 && row < rows && 0 <= col && col < cols && board[row][col] == X) {
          queue.add(new int[]{row, col});
        }
      }
    }
  }

}
