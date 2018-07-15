package interviews.microsoft._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    final List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }

    final int rows = matrix.length, cols = matrix[0].length;
    int startRow = 0, endRow = rows - 1, startCol = 0, endCol = cols - 1;

    while (startRow <= endRow && startCol <= endCol) {
      for (int col = startCol; col <= endCol; col++) {
        result.add(matrix[startRow][col]);
      }
      startRow++;
      for (int row = startRow; row <= endRow; row++) {
        result.add(matrix[row][endCol]);
      }
      endCol--;

      if (startRow <= endRow) {
        for (int col = endCol; col >= startCol; col--) {
          result.add(matrix[endRow][col]);
        }
        endRow--;
      }

      if (startCol <= endCol) {
        for (int row = endRow; row >= startRow; row--) {
          result.add(matrix[row][startCol]);
        }
        startCol++;
      }

    }
    return result;
  }
}
