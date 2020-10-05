package linkedin._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/27/2019
 */
public final class SolutionI implements Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    final List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
    while (result.size() < rows * cols) {
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      top++;
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      right--;
      if (bottom >= top) {
        for (int i = right; i >= left; i--) {
          result.add(matrix[bottom][i]);
        }
        bottom--;
      }
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }
    return result;
  }
}
