package microsoft.noodleEssence._794_Valid_Tic_Tac_Toe_State;

public class Solution {
  private static final char X = 'X', O = 'O';

  public boolean validTicTacToe(String[] board) {
    final int n = 3;
    final int[] rows = new int[3], cols = new int[3];
    int xCount = 0, oCount = 0, dia = 0, anti = 0;
    // check x o count
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        final char chr = board[i].charAt(j);
        final int add = chr == X ? 1 : (chr == O ? -1 : 0);
        rows[i] += add;
        cols[j] += add;
        if (i == j) {
          dia += add;
        }
        if (i + j == n - 1) {
          anti += add;
        }
        switch (chr) {
          case O:
            oCount++;
            break;
          case X:
            xCount++;
            break;
        }
      }
    }

    // check win condition
    if (xCount != oCount && xCount != oCount + 1) {
      return false;
    }

    if (xCount == oCount) {
      // if x is winning return false;
      return !isWin(X, rows, cols, dia, anti);
    }

    if (xCount == oCount + 1) {
      return !isWin(O, rows, cols, dia, anti);
    }

    return true;
  }

  private boolean isWin(final char player, final int[] rows, final int[] cols, final int dia, final int anti) {
    int win = player == X ? 3 : -3;

    for (int r : rows) {
      if (r == win) {
        return true;
      }
    }

    for (int c : cols) {
      if (c == win) {
        return true;
      }
    }

    return dia == win || anti == win;
  }
}
