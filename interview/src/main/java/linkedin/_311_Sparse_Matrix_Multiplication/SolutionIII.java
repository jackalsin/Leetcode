package linkedin._311_Sparse_Matrix_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int[][] multiply(int[][] A, int[][] B) {
    if (A == null || B == null) {
      throw new NullPointerException();
    }
    if (A.length == 0 || B.length == 0 || A[0].length != B.length) {
      throw new IllegalArgumentException();
    }
    final int rows = A.length, cols = B[0].length, m = A[0].length;
    final int[][] res = new int[rows][cols];
    for (int rowA = 0; rowA < rows; ++rowA) {
      for (int colA = 0; colA < m; ++colA) {
        if (A[rowA][colA] == 0) continue;
        final int rowB = colA;
        for (int colB = 0; colB < cols; ++colB) {
          res[rowA][colB] += A[rowA][colA] * B[rowB][colB];
        }
      }
    }
    return res;
  }
}
