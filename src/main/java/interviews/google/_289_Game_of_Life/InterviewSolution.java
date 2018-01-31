package interviews.google._289_Game_of_Life;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public final class InterviewSolution implements Solution {
  @Override
  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    final int rows = board.length, cols = board[0].length;
    final boolean[][] booleanBoard = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        booleanBoard[row][col] = board[row][col] == 1;
      }
    }
    gameOfLife(booleanBoard);
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        board[row][col] = booleanBoard[row][col] ? 1 : 0;
      }
    }
  }

  public void gameOfLife(boolean[][] board) {
    final int rows = board.length, cols = board[0].length;
    boolean[] preRowPreState = new boolean[cols], curRowPreState = new boolean[cols];
    for (int row = 0; row < rows; row++) {
      if (row != 0) {
        System.arraycopy(curRowPreState, 0, preRowPreState, 0, cols);
      }
      System.arraycopy(board[row], 0, curRowPreState, 0, cols);
      for (int col = 0; col < cols; col++) {
        boolean curState = board[row][col];
        int liveNeighbor = getLiveNeighbor(row == 0 ? null : preRowPreState, curRowPreState, row
            == rows - 1 ? null : board[row + 1], col);
        if (curState) {
          board[row][col] = (liveNeighbor == 2 || liveNeighbor == 3);
        } else {
          board[row][col] = liveNeighbor == 3;
        }
      }
    }
  }

  private int getLiveNeighbor(boolean[] preRow, boolean[] curRow, boolean[] nextRow, int col) {
    final int cols = curRow.length;
    int count = 0;
    if (preRow != null) {
      if (col != 0) {
        count += preRow[col - 1] ? 1 : 0;
      }
      count += preRow[col] ? 1 : 0;
      if (col != cols - 1) {
        count += preRow[col + 1] ? 1 : 0;
      }
    }

    if (col != 0) {
      count += curRow[col - 1] ? 1 : 0;
    }
    if (col != cols - 1) {
      count += curRow[col + 1] ? 1 : 0;
    }

    if (nextRow != null) {
      if (col != 0) {
        count += nextRow[col - 1] ? 1 : 0;
      }
      count += nextRow[col] ? 1 : 0;
      if (col != cols - 1) {
        count += nextRow[col + 1] ? 1 : 0;
      }
    }

    return count;
  }
}
