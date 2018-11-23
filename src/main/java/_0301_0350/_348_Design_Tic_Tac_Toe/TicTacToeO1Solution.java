package _0301_0350._348_Design_Tic_Tac_Toe;

/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class TicTacToeO1Solution implements TicTacToe {
  private final int[] rows;
  private final int[] cols;
  private final int size;
  private int diagonal;
  private int antiDiagonal;

  public TicTacToeO1Solution(int n) {
    rows = new int[n];
    cols = new int[n];
    size = n;
  }

  @Override
  public int move(final int row, final int col, final int player) {
    int toAdd = player == 1 ? 1 : -1;
    rows[row] += toAdd;
    cols[col] += toAdd;
    if (row == col) {
      diagonal += toAdd;
    }
    if (row + col == size - 1) {
      antiDiagonal += toAdd;
    }
    if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
        Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
      return player;
    }
    return 0;
  }
}
