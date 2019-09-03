package interviews.linkedin._311_Sparse_Matrix_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 9/2/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int[][] multiply(int[][] A, int[][] B) {
    if (A == null || B == null || A.length == 0 || B.length == 0 || A[0].length != B.length) {
      return null;
    }
    final int rows = A.length, cols = B[0].length, n = A[0].length;
    final int[][] result = new int[rows][cols];
    for (int rowA = 0; rowA < rows; ++rowA) {
      for (int colA = 0; colA < n; ++colA) {
        if (A[rowA][colA] == 0) continue;
        for (int colB = 0; colB < cols; colB++) {
          result[rowA][colB] += A[rowA][colA] * B[colA][colB];
        }
      }
    }
    return result;
  }
}
