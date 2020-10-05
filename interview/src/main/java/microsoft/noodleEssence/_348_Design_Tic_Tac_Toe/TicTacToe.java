package microsoft.noodleEssence._348_Design_Tic_Tac_Toe;

public class TicTacToe {
  private final int n;
  private int[] rows, cols;
  private int dia = 0, anti = 0;

  /**
   * Initialize your data structure here.
   */
  public TicTacToe(int n) {
    assert n > 0;
    this.n = n;
    rows = new int[n];
    cols = new int[n];
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
    player = player == 2 ? -1 : 1;
    rows[row] += player;
    cols[col] += player;
    if (rows[row] == n || cols[col] == n) {
      return 1;
    } else if (rows[row] == -n || cols[col] == -n) {
      return 2;
    }

    if (row == col) {
      dia += player;
      if (dia == n) {
        return 1;
      } else if (dia == -n) {
        return 2;
      }
    }

    if (row + col == n - 1) {
      anti += player;
      if (anti == n) {
        return 1;
      } else if (anti == -n) {
        return 2;
      }
    }
    return 0;
  }
}
