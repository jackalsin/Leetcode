package _0551_0600._566_Reshape_the_Matrix;

/**
 * @author jacka
 * @version 1.0 on 1/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    final int rows = nums.length, cols = nums[0].length;
    if ((long) rows * cols != (long) r * c) {
      return nums;
    }
    final int[][] result = new int[r][c];
    for (long i = 0; i < (long) rows * cols; i++) {
      final int srcRow = (int) (i / cols), srcCol = (int) (i % cols),
          tgtRow = (int) (i / c), tgtCol = (int) (i % c);
      result[tgtRow][tgtCol] = nums[srcRow][srcCol];
    }
    return result;
  }
}
