package interviews.uber._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    final List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
    while (startRow <= endRow && startCol <= endCol) {
      for (int col = startCol; col <= endCol; col++) {
        result.add(matrix[startRow][col]);
      }
      for (int row = startRow + 1; row <= endRow; row++) {
        result.add(matrix[row][endCol]);
      }
      if (startRow < endRow) {
        for (int col = endCol - 1; col >= startCol; col--) {
          result.add(matrix[endRow][col]);
        }
      }
      if (startCol < endCol) {
        for (int row = endRow - 1; row > startRow; row--) {
          result.add(matrix[row][startCol]);
        }
      }
      startCol++;
      endCol--;
      startRow++;
      endRow--;
    }
    return result;
  }
}
