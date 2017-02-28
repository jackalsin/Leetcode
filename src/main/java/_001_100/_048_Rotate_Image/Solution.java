package _001_100._048_Rotate_Image;

/**
 * @author jacka
 * @version 1.0 on 2/27/2017.
 */
public class Solution {

  public void rotate(int[][] matrix) {
    if (matrix != null && matrix.length != 0) {
      ringByRingSolution(matrix); // 3 ms
//      twoPassSolution(); // untested
    }
  }

  private static void ringByRingSolution(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    for (int row = 0; row <= (rows - 1) / 2; row++) {
      for (int col = row; col < (cols - 1 - row); col++) {
        // swap
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[rows - 1 - col][row];
        matrix[rows - 1 - col][row] = matrix[rows - 1 - row][cols - 1 - col];
        matrix[rows - 1 - row][cols - 1 - col] = matrix[col][rows - 1 - row];
        matrix[col][rows - 1 - row] = tmp;
      }
    }
  }

  private static void twoPassSolution() {

  }
}
