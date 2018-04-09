package _401_450._413_Arithmetic_Slices;

public final class Dp2dSolution implements Solution {

  public int numberOfArithmeticSlices(int[] A) {
    if (A == null || A.length < 3) {
      return 0;
    }
    final int[][] dp = new int[A.length][A.length];
    for (int row = A.length - 3; row >= 0; row--) {
      final int startCol = row + 2;
      dp[row][row + 2] =
          (A[startCol] - A[startCol - 1]) == (A[startCol - 1] - A[startCol - 2]) ? 1 : 0;
      for (int col = startCol + 1; col < A.length; col++) {
        //                                                    remove duplicate`
        dp[row][col] = dp[row + 1][col];
        if (dp[row][col - 1] > 0 && (A[col] - A[col - 1] == A[col - 1] - A[col - 2])) {
          dp[row][col] += dp[row][col - 1] - dp[row + 1][col - 1];
        }
      }
    }
    int res = 0;
    for (int col = 0; col < A.length; col++) {
      res += dp[0][col];
    }
    return res;
  }
}
