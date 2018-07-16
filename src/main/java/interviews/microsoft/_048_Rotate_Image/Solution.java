package interviews.microsoft._048_Rotate_Image;

public class Solution {
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    final int rows = matrix.length, cols = matrix[0].length;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < row; col++) {
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = tmp;
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols / 2; col++) {
        swap(matrix[row], col, cols - 1 - col);
      }
    }

  }

  private static void swap(int[] matrix, int i, int j) {
    int tmp = matrix[i];
    matrix[i] = matrix[j];
    matrix[j] = tmp;
  }
}
