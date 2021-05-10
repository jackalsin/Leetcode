package google._308_Range_Sum_Query_2D_Mutable;

/**
 * @author jacka
 * @version 1.0 on 9/16/2017.
 */
public final class NumMatrixI implements NumMatrix {
  private final int[][] trees;
  private final int rows;
  private final int cols;
  private final int[][] matrix;

  public NumMatrixI(int[][] matrix) {
    this.matrix = matrix;
    rows = matrix == null ? 0 : matrix.length;
    cols = rows == 0 ? 0 : matrix[0].length;
    trees = new int[rows + 1][cols + 1];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        updateByDiff(row, col, matrix[row][col]);
      }
    }
  }

  public void update(int row, int col, int val) {
    updateByDiff(row, col, val - matrix[row][col]);
    matrix[row][col] = val;
  }

  void updateByDiff(int row, int cCol, int diff) {
    ++row;
    ++cCol;
    final int col = cCol;
    while (row <= rows) {
      int c = col;
      while (c <= cols) {
        trees[row][c] += diff;
        c += (c & -c);
      }
      row += (row & -row);
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row1 - 1, col2) - getSum
        (row2, col1 - 1);
  }

  int getSum(int r, int c) {
    int sum = 0;
    final int col = c + 1;
    r++;
    while (r > 0) {
      c = col;
      while (c > 0) {
        sum += trees[r][c];
        c -= (c & -c);
      }
      r -= (r & -r);
    }
    return sum;
  }
}
