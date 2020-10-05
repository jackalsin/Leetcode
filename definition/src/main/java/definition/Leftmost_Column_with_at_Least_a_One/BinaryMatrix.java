package definition.Leftmost_Column_with_at_Least_a_One;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
public final class BinaryMatrix {
  private final int[][] matrix;

  public BinaryMatrix(final int[][] matrix) {
    if (matrix == null) {
      throw new NullPointerException();
    }
    final int rows = matrix.length;
    if (rows == 0) {
      this.matrix = new int[rows][];
      return;
    }
    final int cols = matrix[0].length;
    this.matrix = new int[rows][cols];
    for (int i = 0; i < rows; ++i) {
      System.arraycopy(matrix[i], 0, this.matrix[i], 0, cols);
    }
  }

  public int get(final int x, final int y) {
    return matrix[x][y];
  }

  public List<Integer> dimensions() {
    final int row = matrix.length;
    return List.of(row, row == 0 ? 0 : matrix[0].length);
  }
}
