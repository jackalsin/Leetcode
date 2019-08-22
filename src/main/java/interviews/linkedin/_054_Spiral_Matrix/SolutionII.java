package interviews.linkedin._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/21/2019
 */
public final class SolutionII implements Solution {
  @Override
  public List<Integer> spiralOrder(int[][] matrix) {
    final List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
    while (result.size() < rows * cols) {
      for (int col = left; col <= right; ++col) {
        result.add(matrix[top][col]);
      }
      ++top;
      for (int row = top; row <= bottom; ++row) {
        result.add(matrix[row][right]);
      }
      --right;
      if (bottom >= top) {
        for (int col = right; col >= left; --col) {
          result.add(matrix[bottom][col]);
        }
        --bottom;
      }
      if (left <= right) {
        for (int row = bottom; row >= top; --row) {
          result.add(matrix[row][left]);
        }
        left++;
      }
    }
    return result;
  }
}
