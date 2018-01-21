package interviews.google.sum_array;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public class Solution {
  public int[][] getSum(int[][] nums) {
    if (nums.length == 0 || nums[0].length == 0) {
      return new int[0][];
    }
    final int rows = nums.length, cols = nums[0].length;
    final int[][] sums = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int delete = (row == 0 || col == 0) ? 0 : sums[row - 1][col - 1];
        int top = row == 0 ? 0 : sums[row - 1][col];
        int left = col == 0 ? 0 : sums[row][col - 1];
        sums[row][col] = top + left - delete + nums[row][col];
      }
    }
    return sums;
  }
}
