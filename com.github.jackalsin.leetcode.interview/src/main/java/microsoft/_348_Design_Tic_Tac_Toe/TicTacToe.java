package microsoft._348_Design_Tic_Tac_Toe;

public final class TicTacToe {

  private final int n;

  private final int[][] playerHorizontal, playerVertical;

  /* playerId, diagonal, row == col -> 0, otherwise,1 */
  private final int[][] playerDiaCount;

  /**
   * Initialize your data structure here.
   */
  public TicTacToe(int n) {
    this.n = n;
    playerHorizontal = new int[2][n];
    playerVertical = new int[2][n];

    playerDiaCount = new int[2][2];
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either:
   * 0: No one wins.
   * 1: Player 1 wins.
   * 2: Player 2 wins.
   */
  public int move(int row, int col, int player) {
    if (++playerHorizontal[player - 1][row] == n) {
      return player;
    }

    if (++playerVertical[player - 1][col] == n) {
      return player;
    }

    if (row == col && ++playerDiaCount[player - 1][0] == n) {
      return player;
    }

    if (row + col == n - 1 && ++playerDiaCount[player - 1][1] == n) {
      return player;
    }
    return 0;
  }
}
