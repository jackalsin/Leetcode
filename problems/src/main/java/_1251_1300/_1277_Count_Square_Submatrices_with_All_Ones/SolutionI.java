package _1251_1300._1277_Count_Square_Submatrices_with_All_Ones;

/**
 * @author jacka
 * @version 1.0 on 5/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int countSquares(int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] sides = new int[rows + 1][cols + 1];
    int res = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (matrix[i][j] == 1) {
          sides[i + 1][j + 1] = min(sides[i][j + 1], sides[i][j], sides[i + 1][j]) + 1;
        }
        res += sides[i + 1][j + 1];
      }
    }
    return res;
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(c, a);
    }
    return a;
  }
}
