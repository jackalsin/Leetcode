package _0851_0900._861_Score_After_Flipping_Matrix;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int matrixScore(int[][] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int rows = A.length, cols = A[0].length;
    final int[] ones = new int[cols];
    for (int i = 0; i < rows; ++i) {
      final boolean shouldFlip = A[i][0] == 0;
      for (int j = 0; j < cols; ++j) {
        if (shouldFlip) {
          ones[j] += 1 - A[i][j];
        } else {
          ones[j] += A[i][j];
        }
      }
    }
//    System.out.println(Arrays.toString(ones));
    int sum = 0;
    for (int j = 0; j < cols; ++j) {
      sum += Math.max(rows - ones[j], ones[j]) * (1 << (cols - 1 - j));
    }
    return sum;
  }
}
