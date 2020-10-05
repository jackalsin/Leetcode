package definition._054_Spiral_Matrix;

/**
 * @author zhixi
 * @version 1.0 on 5/6/2020
 */
public final class Board {
  private Board() {
  }

  public static int[][] get2dBoard(int rows, int cols) {
    int[][] result = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        result[row][col] = row * cols + col + 1;
      }
    }
    return result;
  }
}
