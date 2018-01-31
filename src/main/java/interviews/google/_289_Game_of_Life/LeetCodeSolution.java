package interviews.google._289_Game_of_Life;

/**
 * @author jacka
 * @version 1.0 on 1/29/2018.
 */
public final class LeetCodeSolution implements Solution {
  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 1},
      {1, -1}, {1, 0}, {1, 1},
  };

  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int curState = board[row][col] & 1;
        int liveNeighbors = getNext(board, row, col);
        int nextState = 0;
        if (curState == 0) {
          nextState = liveNeighbors == 3 ? 1 : 0;
        } else {
          nextState = (liveNeighbors <= 3 && liveNeighbors >= 2) ? 1 : 0;
        }
        board[row][col] |= (nextState << 1);
      }
    }
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        board[row][col] >>>= 1;
      }
    }
  }

  private int getNext(final int[][] board, final int row, final int col) {
    int count = 0;
    final int rows = board.length, cols = board[0].length;
    for (final int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (nextRow < rows && nextRow >= 0 && nextCol >= 0 && nextCol < cols) {
        count += (board[nextRow][nextCol] & 1);
      }
    }
    return count;
  }
}
