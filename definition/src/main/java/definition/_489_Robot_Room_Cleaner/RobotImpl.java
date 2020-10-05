package definition._489_Robot_Room_Cleaner;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/5/2020
 */
public final class RobotImpl implements Robot {
  private int x = 0, y = 0;
  private final int[][] board;
  private final int rows, cols;
  private static final Direction[] DIRS = {
      new Direction(1, 0), // down
      new Direction(0, -1), // left
      new Direction(-1, 0), // up
      new Direction(0, 1), // right
  };
  private int direction = 0;

  public RobotImpl(final int[][] board, final int[] start) {
    if (board == null) {
      throw new NullPointerException();
    }
    rows = board.length;
    cols = board[0].length;
    this.board = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      System.arraycopy(board[row], 0, this.board[row], 0, cols);
    }
    x = start[0];
    y = start[1];
  }

  @Override
  public boolean move() {
    final Direction dir = DIRS[direction];
    final int nextRow = x + dir.dx,
        nextCol = y + dir.dy;
    if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || board[nextRow][nextCol] == 0) {
      return false;
    }
    x = nextRow;
    y = nextCol;
    return true;
  }

  @Override
  public void turnLeft() {
    direction = (direction - 1) % 4;
  }

  @Override
  public void turnRight() {
    direction = (direction + 1) % 4;
  }

  @Override
  public void clean() {
    board[x][y]++;
  }

  public int[][] getBoard() {
    final int[][] result = new int[rows][cols];
    for (int i = 0; i < rows; ++i) {
      System.arraycopy(board[i], 0, result[i], 0, cols);
    }
    return result;
  }

  @Override
  public String toString() {
    return "Robot is on [" + x + ", " + y + "], direction = " + DIRS[direction] + ",\n\t\tboard=" + Arrays.deepToString(board);
  }

  private static final class Direction {
    private final int dx, dy;

    private Direction(int dx, int dy) {
      assert -1 <= dx && dx <= 1 && -1 <= dy && dy <= 1;
      this.dx = dx;
      this.dy = dy;
    }

    @Override
    public String toString() {
      if (dx == 0 && dy == 1) {
        return "Right";
      } else if (dx == 0) {
        return "Left";
      } else if (dx == 1 && dy == 0) {
        return "Down";
      } else {
        return "Up";
      }
    }
  }
}
