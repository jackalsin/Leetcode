package _101_150._130_Surrounded_Regions;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public void solve(char[][] board) {
    int rows = board.length;
    if (rows == 0) return;
    int cols = board[0].length;
    if (cols == 0) return;

    for(int col = 0; col < cols; col++) {
      updateBoard(board, 0, col);
      if (rows > 1) {
        updateBoard(board, rows -1, col);
      }
    }

    for (int row = 0; row < rows; row++) {
      updateBoard(board, row, 0);
      if (cols > 1) {
        updateBoard(board, row, cols - 1);
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        board[row][col] = board[row][col] == '1' ? 'O' : 'X';
      }
    }
  }

  private void updateBoard(final char[][] board, int row, int col) {
    if (board[row][col] == 'O') {
      board[row][col] = '1';
      if (row > 1) {
        updateBoard(board, row - 1 , col);
      }
      if (col > 1) {
        updateBoard(board, row, col - 1);
      }
      int rows = board.length;
      int cols = board[0].length;
      if (col < cols -1) {
        updateBoard(board, row, col + 1);
      }
      if (row < rows - 1) {
        updateBoard(board, row + 1, col);
      }
    }
  }
}
