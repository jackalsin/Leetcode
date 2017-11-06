package _351_400._363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class Solution {

  public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    final int rows = matrix.length, cols = matrix[0].length;

    for (int col = 0; col < cols; col++) {
      final int[] sums = new int[rows];
      for (int row = 0; row < rows; row++) {
        sums[col] += matrix[row][col];
      }

      TreeSet<Integer> preSumSet = new TreeSet<>();
      preSumSet.add(0);
      int curSum = 0, curMax = 0;
      for (int sum : sums) {
        curSum += sum;
      }

    }
    return 0;
  }

  public static void main(String[] args) {
    new Solution().maxSumSubmatrix(new int[][]{{1,2, 3}, {3, 2, 3}}, 2);
  }
}
