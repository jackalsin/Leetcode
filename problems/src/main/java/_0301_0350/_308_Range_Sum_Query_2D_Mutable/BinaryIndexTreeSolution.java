package _0301_0350._308_Range_Sum_Query_2D_Mutable;

/**
 * @author jacka
 * @version 1.0 on 9/16/2017.
 */
public final class BinaryIndexTreeSolution implements NumMatrix {
  private final int[][] trees;
  private final int rows;
  private final int cols;
  private final int[][] matrix;

  public BinaryIndexTreeSolution(int[][] matrix) {
    rows = matrix.length;
    cols = rows == 0 ? 0 : matrix[0].length;
    trees = new int[rows + 1][cols + 1];
    this.matrix = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        update(row, col, matrix[row][col]);
      }
    }
  }

  public void update(int row, int col, int val) {
    int diff = val - matrix[row][col];
    matrix[row][col] = val;
    ++row;
    ++col;
    while (row <= rows) {
      int newCol = col;
      while (newCol <= cols) {
        trees[row][newCol] += diff;
        newCol += (newCol & -newCol);
      }
      row += (row & -row);
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return getSum(row1 - 1, col1 - 1) + getSum(row2, col2)
        - getSum(row1 - 1, col2) - getSum(row2, col1 - 1);
  }

  int getSum(int row, int col) {
    ++row;
    ++col;
    int sum = 0;
    while (row > 0) {
      int newCol = col;
      while (newCol > 0) {
        sum += trees[row][newCol];
        newCol -= (newCol & -newCol);
      }
      row -= (row & -row);
    }
    return sum;
  }
}
