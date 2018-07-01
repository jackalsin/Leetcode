package _751_800._794_Valid_Tic_Tac_Toe_State;

public class Solution {
  private static final char X = 'X', O = 'O';

  public boolean validTicTacToe(String[] stringBoard) {
    final char[][] board = getBoard(stringBoard);
    int countOfO = 0, countOfX = 0;
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        switch (board[row][col]) {
          case X:
            countOfX++;
            break;
          case O:
            countOfO++;
            break;
        }
      }
    }

    if (!(countOfO == countOfX || countOfO + 1 == countOfX)) {
      return false;
    }

    if (win(board, O) && countOfO != countOfX) {
      return false;
    }

    return !win(board, X) || countOfO + 1 == countOfX;
  }

  private static char[][] getBoard(String[] board) {
    final char[][] res = new char[3][3];
    for (int i = 0; i < board.length; i++) {
      final String s = board[i];
      System.arraycopy(s.toCharArray(), 0, res[i], 0, board.length);
    }
    return res;
  }

  private static boolean win(final char[][] board, final char player) {
    // no row winner
    for (final char[] row : board) {
      int count = 0;
      for (final char chr : row) {
        if (chr == player) {
          count++;
        }
      }
      if (count == 3) {
        return true;
      }
    }

    // no col winner
    for (int col = 0; col < 3; col++) {
      int count = 0;
      for (int row = 0; row < 3; row++) {
        if (player == board[row][col]) {
          count++;
        }
      }
      if (count == 3) {
        return true;
      }
    }

    // no diagonal
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    return board[2][0] == player && board[1][1] == player && board[0][2] == player;
  }

}
