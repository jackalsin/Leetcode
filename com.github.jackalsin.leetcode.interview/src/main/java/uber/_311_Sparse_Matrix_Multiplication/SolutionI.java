package uber._311_Sparse_Matrix_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 1/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] multiply(int[][] A, int[][] B) {
    final int rowsA = A.length, colsA = A[0].length,
        rowsB = B.length, colsB = B[0].length;
    final int[][] C = new int[rowsA][colsB];
    for (int rowA = 0; rowA < rowsA; rowA++) {
      for (int colA = 0; colA < colsA; colA++) {
        if (A[rowA][colA] == 0) continue;
        final int rowB = colA;
        for (int colB = 0; colB < colsB; ++colB) {
          C[rowA][colB] += A[rowA][colA] * B[rowB][colB];
        }
      }
    }
    return C;
  }
}
