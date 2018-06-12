package interviews.microsoft._794_Valid_Tic_Tac_Toe_State;

public class Solution {

  private static final char X = 'X', O = 'O';

  /**
   * 108 / 108 test cases passed.
   * Status: Accepted
   * Runtime: 8 ms
   *
   * @param board
   * @return
   */
  public boolean validTicTacToe(String[] board) {
    int xCount = 0, oCount = 0;
    for (String line : board) {
      for (int i = 0; i < line.length(); i++) {
        switch (line.charAt(i)) {
          case X:
            xCount++;
            break;
          case O:
            oCount++;
            break;
        }
      }
    }

    if (xCount != oCount && xCount != oCount + 1) {
      return false;
    }
    if (win(board, X) && oCount != xCount - 1) {
      return false;
    }
    if (win(board, O) && oCount != xCount) {
      return false;
    }

    return true;
  }

  private boolean win(String[] board, char player) {
    for (String line : board) {
      if (line.charAt(0) == player && line.charAt(0) == line.charAt(1) && line.charAt(1) == line.charAt(2)) {
        return true;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (board[0].charAt(i) == player && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2]
          .charAt(i)) {
        return true;
      }
    }
    if (
        board[1].charAt(1) == player && (
            (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) ||
                (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))
        )) {
      return true;
    }
    return false;
  }
}
