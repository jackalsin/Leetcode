package _0301_0350._348_Design_Tic_Tac_Toe;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid. You may assume the
 * following rules: A move is guaranteed to be valid and is placed on an empty block. Once a winning
 * condition is reached, no more moves is allowed. A player who succeeds in placing n of their marks
 * in a horizontal, vertical, or diagonal row wins the game.
 *
 * Example: Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 *
 * TicTacToe toe = new TicTacToe(3);
 *
 * toe.move(0, 0, 1); -> Returns 0 (no one wins) |X| | | | | | |    // Player 1 makes a move at (0,
 * 0). | | | |
 *
 * toe.move(0, 2, 2); -> Returns 0 (no one wins) |X| |O| | | | |    // Player 2 makes a move at (0,
 * 2). | | | |
 *
 * toe.move(2, 2, 1); -> Returns 0 (no one wins) |X| |O| | | | |    // Player 1 makes a move at (2,
 * 2). | | |X|
 *
 * toe.move(1, 1, 2); -> Returns 0 (no one wins) |X| |O| | |O| |    // Player 2 makes a move at (1,
 * 1). | | |X|
 *
 * toe.move(2, 0, 1); -> Returns 0 (no one wins) |X| |O| | |O| |    // Player 1 makes a move at (2,
 * 0). |X| |X|
 *
 * toe.move(1, 0, 2); -> Returns 0 (no one wins) |X| |O| |O|O| |    // Player 2 makes a move at (1,
 * 0). |X| |X|
 *
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins) |X| |O| |O|O| |    // Player 1 makes a move at
 * (2, 1). |X|X|X|
 *
 * Follow up: Could you do better than O(n2) per move() operation?
 *
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public final class TicTacToeONSolution implements TicTacToe {
  private final int[][] board;

  /**
   * Initialize your data structure here.
   */
  public TicTacToeONSolution(int n) {
    board = new int[n][n];
  }

  @Override
  public int move(int row, int col, int player) {
    board[row][col] = player;
    int left = board[row][0];
    int top = board[0][col];
    // horizontal
    boolean isWin = true;
    if (left != 0) {
      for (int i = 1; i < board.length; ++i) {
        if (board[row][i] != left) {
          isWin = false;
        }
      }
      if (isWin) {
        return player;
      }
    }
    // vertical
    isWin = true;
    if (top != 0) {
      for (int i = 1; i < board.length; ++i) {
        if (board[i][col] != top) {
          isWin = false;
        }
      }
      if (isWin) {
        return player;
      }
    }
    isWin = true;
    // triangle
    if (row == col) {
      int leftTop = board[0][0];
      if (leftTop != 0) {
        for (int i = 1; i < board.length; ++i) {
          if (leftTop != board[i][i]) {
            isWin = false;
          }
        }
        if (isWin) {
          return player;
        }
        isWin = true;
      }
    }

    if (row + col == board.length - 1) {
      int rightTop = board[0][board.length - 1];
      if (rightTop != 0) {
        for (int i = 1; i < board.length; ++i) {
          if (rightTop != board[i][board.length - 1 - i]) {
            isWin = false;
          }
        }
        if (isWin) {
          return player;
        }
      }
    }
    return 0;
  }
}
