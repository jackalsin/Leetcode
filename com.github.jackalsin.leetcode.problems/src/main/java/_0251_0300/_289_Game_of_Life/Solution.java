package _0251_0300._289_Game_of_Life;

/**
 * @author jacka
 * @version 1.0 on 9/5/2017.
 */
public class Solution {

  private static final int[][] DIRS = {
      {1, 1}, {1, 0}, {1, -1},
      {0, 1}, {0, -1},
      {-1, 1}, {-1, 0}, {-1, -1}};

  /**
   * https://discuss.leetcode.com/topic/29054/easiest-java-solution-with-explanation
   * 00 dead <- dead
   * 10 live <- dead
   * 01 dead <- live
   * 11 live <- live
   *
   * @param board
   */
  public void gameOfLife(int[][] board) {
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        int neighbors = getNeighbors(board, row, col);
        if (board[row][col] == 1 && (neighbors == 2 || neighbors == 3)) {
          board[row][col] += 2;
        } else if (board[row][col] == 0 && neighbors == 3) {
          board[row][col] += 2;
        }
      }
    }

    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        board[row][col] >>= 1;
      }
    }

  }

  private int getNeighbors(int[][] board, int startRow, int startCol) {
    int count = 0;
    final int rows = board.length, cols = board[0].length;
    for (int[] dir : DIRS) {
      final int row = startRow + dir[0], col = startCol + dir[1];
      if (row >= 0 && row < rows && col >= 0 && col < cols && (board[row][col] & 1) == 1) count++;
    }
    return count;
  }
}
