package _401_450._419_Battleships_in_a_Board;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class Solution {
  private static final char X = 'X';
  private static final char DOT = '.';

  public int countBattleships(char[][] board) {
    int count = 0;
    if (board == null || board.length == 0) {
      return count;
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (board[row][col] == X) {
          if ((col == cols - 1 || board[row][col + 1] == DOT)
              && (row == rows - 1 || board[row + 1][col] == DOT)) {
            count++;
          } // end of inner if
        }
      } // end of col loop
    }
    return count;
  }
}
