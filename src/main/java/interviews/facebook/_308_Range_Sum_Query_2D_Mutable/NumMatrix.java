package interviews.facebook._308_Range_Sum_Query_2D_Mutable;

public final class NumMatrix {

  private final int tree[][], matrix[][], rows, cols;

  public NumMatrix(int[][] matrix) {
    rows = matrix.length;
    cols = rows == 0 ? 0 : matrix[0].length;
    tree = new int[rows + 1][cols + 1];
    this.matrix = matrix;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        updateHelper(row, col, matrix[row][col]);
        this.matrix[row][col] = matrix[row][col];
      }
    }
  }

  public void update(int row, int col, int val) {
    updateHelper(row, col, val - matrix[row][col]);
    matrix[row][col] = val;
  }

  private void updateHelper(int row, int col, final int diff) {
    ++row;
    ++col;
    while (row <= rows) {
      int newCol = col;

      while (newCol <= cols) {
        tree[row][newCol] += diff;
        newCol += (newCol & -newCol);
      }

      row += (row & -row);
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumRegionHelper(row2, col2) + sumRegionHelper(row1 - 1, col1 - 1)
        - sumRegionHelper(row2, col1 - 1) - sumRegionHelper(row1 - 1, col2);
  }

  private int sumRegionHelper(int row, int col) {
    ++row;
    ++col;
    int sum = 0;
    while (row > 0) {
      int newCol = col;
      while (newCol > 0) {
        sum += tree[row][newCol];
        newCol -= (newCol & -newCol);
      }
      row -= (row & -row);
    }

    return sum;
  }
}
