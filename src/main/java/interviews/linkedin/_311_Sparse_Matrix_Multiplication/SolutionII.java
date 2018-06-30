package interviews.linkedin._311_Sparse_Matrix_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public int[][] multiply(int[][] A, int[][] B) {
    if (A == null || A.length == 0) {
      return new int[][]{};
    }
    if (B == null || B.length == 0) {
      return new int[][]{};
    }

    final int[][] C = new int[A.length][B[0].length];

    for (int i = 0; i < A.length; i++) {
      for (int k = 0; k < A[0].length; k++) {
        if (A[i][k] == 0) {
          continue;
        }

        for (int j = 0; j < B[0].length; j++) {
          C[i][j] += A[i][k] * B[k][j];
        }
      }
    }
    return C;
  }

}
