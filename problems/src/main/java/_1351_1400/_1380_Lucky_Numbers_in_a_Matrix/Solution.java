package _1351_1400._1380_Lucky_Numbers_in_a_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public class Solution {
  public List<Integer> luckyNumbers(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }

    final List<Integer> result = new ArrayList<>();
    final int m = matrix.length, n = matrix[0].length;

    final int[] maxCols = new int[n];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i == 0) {
          maxCols[j] = matrix[i][j];
        } else {
          maxCols[j] = Math.max(maxCols[j], matrix[i][j]);
        }
      }
    }

    for (int i = 0; i < m; ++i) {
      int min = matrix[i][0], minIndex = 0;
      for (int j = 1; j < n; ++j) {
        if (matrix[i][j] < min) {
          min = Math.min(min, matrix[i][j]);
          minIndex = j;
        }
      } // ed of col
      if (matrix[i][minIndex] == maxCols[minIndex]) {
        result.add(matrix[i][minIndex]);
      }
    }
    return result;
  }
}
