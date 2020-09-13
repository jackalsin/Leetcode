package _0851_0900._867_Transpose_Matrix;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] transpose(int[][] A) {
    final int rows = A.length, cols = A[0].length;
    final int[][] B = new int[cols][rows];
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        B[j][i] = A[i][j];
      }
    }
    return B;
  }
}
