package _1351_1400._1351_Count_Negative_Numbers_in_a_Sorted_Matrix;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public final  class SolutionI implements Solution {
  public int countNegatives(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int result = 0, firstNeg = cols;
    for (final int[] nums : grid) {
      while (firstNeg - 1 >= 0 && nums[firstNeg - 1] < 0) {
        firstNeg--;
      }
      result += cols - 1 - firstNeg + 1;
    }
    return result;
  }
}
