package interviews.linkedin._311_Sparse_Matrix_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public int[][] multiply(int[][] A, int[][] B) {
    int rowsA = A.length;
    if (rowsA == 0) {
      return new int[][]{};
    }
    int colsA = A[0].length, rowsB = B.length;
    if (rowsB == 0) {
      return new int[][]{};
    }
    int colsB = B[0].length;
    final int[][] result = new int[rowsA][colsB];
    for (int row = 0; row < rowsA; row++) {
      for (int k = 0; k < colsA; k++) {
        if (A[row][k] == 0) {
          continue;
        }
        for (int col = 0; col < colsB; col++) {
          if (B[k][col] != 0) {
            result[row][col] += A[row][k] * B[k][col];
          }
        }
      }
    }
    return result;
  }

  private int[][] navieSolution(int[][] A, int[][] B) {
    int rowsA = A.length;
    if (rowsA == 0) {
      return new int[][]{};
    }
    int colsA = A[0].length, rowsB = B.length;
    if (rowsB == 0) {
      return new int[][]{};
    }
    int colsB = B[0].length;
    final int[][] result = new int[rowsA][colsB];
    for (int row = 0; row < rowsA; row++) {
      for (int col = 0; col < colsB; col++) {
        for (int k = 0; k < colsA; k++) {
          result[row][col] += A[row][k] * B[k][col];
        }
      }
    }
    return result;

  }
}
