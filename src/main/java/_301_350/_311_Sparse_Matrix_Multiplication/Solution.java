package _301_350._311_Sparse_Matrix_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 9/17/2017.
 */
public class Solution {

  public int[][] multiply(int[][] A, int[][] B) {
//    return naiveSolution(A, B);
    return smartSolution(A, B);
  }

  /**
   *
   *  <link>https://discuss.leetcode.com/topic/72871/54ms-detailed-summary-of-easiest-java
   *  -solutions-beating-99-9</link>
   * @param A
   * @param B
   * @return
   */
  private int[][] smartSolution(int[][] A, int[][] B) {
    int rowsA = A.length, rowsB = B.length;
    if (rowsA == 0 || rowsB == 0) return new int[][]{};
    int colsA = A[0].length, colsB = B[0].length;
    final int[][] C = new int[rowsA][colsB];
    for (int i = 0; i < rowsA; ++i) {
      for (int k = 0; k < colsA; ++k) {
        if (A[i][k] != 0) {
          for (int j = 0; j < colsB; ++j) {
            C[i][j] += A[i][k] * B[k][j];
          }
        }
      }
    }

    return C;
  }

  private int[][] naiveSolution(int[][] A, int[][] B) {
    int rowsA = A.length, rowsB = B.length;
    if (rowsA == 0 || rowsB == 0) return new int[][]{};
    int colsA = A[0].length, colsB = B[0].length;
    final int[][] C = new int[rowsA][colsB];
    for (int row = 0; row < rowsA; ++row) {
      for (int col = 0; col < colsB; ++col) {
        for (int k = 0; k < rowsB; ++k) {
          C[row][col] += A[row][k] * B[k][col];
        }
      }
    }
    return C;
  }

}
