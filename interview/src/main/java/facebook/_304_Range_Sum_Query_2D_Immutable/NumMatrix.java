package facebook._304_Range_Sum_Query_2D_Immutable;

public class NumMatrix {
  private int[][] presum;

  public NumMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    presum = new int[rows + 1][cols + 1];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        presum[row + 1][col + 1] = presum[row][col + 1] + presum[row + 1][col]
            - presum[row][col] + matrix[row][col];
      }
    }
//    System.out.println(Arrays.deepToString(presum));
//    TwoDimensionArray.display(presum);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] -
        presum[row1][col2 + 1] + presum[row1][col1];
  }
}
