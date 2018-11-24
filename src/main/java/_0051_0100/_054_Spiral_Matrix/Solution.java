package _0051_0100._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/27/2017.
 */
public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    int rowBegin = 0, colBegin = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
    while (rowBegin <= rowEnd && colBegin <= colEnd) {
      for (int col = colBegin; col <= colEnd; col++) {
        result.add(matrix[rowBegin][col]);
      }
      rowBegin++;
      for (int row = rowBegin; row <= rowEnd; row++) {
        result.add(matrix[row][colEnd]);
      }
      colEnd--;
      if (rowBegin <= rowEnd) {
        for (int col = colEnd; col >= colBegin; col--) {
          result.add(matrix[rowEnd][col]);
        }
        rowEnd--;
      }
      if (colBegin <= colEnd) {
        for (int row = rowEnd; row >= rowBegin; row--) {
          result.add(matrix[row][colBegin]);
        }
        colBegin++;
      }
    }
    return result;
  }

//  public static void main(String[] args) {
//    System.out.println(3/2); // 1
//    System.out.println(5/2); // 2
//    System.out.println(-5/2); // -2
//  }
}
