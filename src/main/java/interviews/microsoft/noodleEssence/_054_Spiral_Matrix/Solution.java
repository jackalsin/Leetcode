package interviews.microsoft.noodleEssence._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    final List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int startRow = 0, startCol = 0, endCol = cols - 1, endRow = rows - 1;
    int k = 0;
    while (k < rows * cols) {
      for (int i = startCol; i <= endCol; i++, k++) {
        result.add(matrix[startRow][i]);
      }

      startRow++;

      for (int row = startRow; row <= endRow; row++, k++) {
        result.add(matrix[row][endCol]);
      }
      endCol--;

      if (startRow <= endRow) {
        for (int col = endCol; col >= startCol; col--, k++) {
          result.add(matrix[endRow][col]);
        }
        endRow--;
      }
      if (startCol <= endCol) {
        for (int row = endRow; row >= startRow; row--, k++) {
          result.add(matrix[row][startCol]);
        }
        startCol++;
      }

    }
    return result;
  }
}
