package _1551_1600._1594_Maximum_Non_Negative_Product_in_a_Matrix;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private Long[][] maxProd, minProd/*, maxSign, minSign*/;

  public int maxProductPath(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    maxProd = new Long[rows][cols];
    minProd = new Long[rows][cols];
    maxProd[0][0] = minProd[0][0] = (long) grid[0][0];
    for (int col = 1; col < cols; col++) {
      final long prod = grid[0][col] * maxProd[0][col - 1];
      maxProd[0][col] = minProd[0][col] = prod;
    }
    for (int row = 1; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        { // from top
          update(row, col, grid, row - 1, col);
        }

        if (col > 0) { // from left
          update(row, col, grid, row, col - 1);
        }
      }
    }
    return maxProd[rows - 1][cols - 1] >= 0 ? (int) ((MOD + maxProd[rows - 1][cols - 1]) % MOD) : -1;
  }

  private void update(final int row, final int col, final int[][] grid, final int fromRow, final int fromCol) {
    final long prodWithMax = maxProd[fromRow][fromCol] * grid[row][col],
        prodWithMin = minProd[fromRow][fromCol] * grid[row][col],
        max = Math.max(prodWithMax, prodWithMin), min = Math.min(prodWithMax, prodWithMin);
    if (maxProd[row][col] == null) {
      maxProd[row][col] = max;
    }
    if (minProd[row][col] == null) {
      minProd[row][col] = min;
    }
    maxProd[row][col] = Math.max(maxProd[row][col], max);
    minProd[row][col] = Math.min(minProd[row][col], min);
  }
}
