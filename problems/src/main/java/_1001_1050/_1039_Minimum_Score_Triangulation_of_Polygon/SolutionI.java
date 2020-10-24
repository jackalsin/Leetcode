package _1001_1050._1039_Minimum_Score_Triangulation_of_Polygon;

/**
 * @author zhixi
 * @version 1.0 on 10/23/2020
 */
public final class SolutionI implements Solution {
  private final int[][] dp = new int[50][50];

  /**
   * <a href='https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286753/C%2B%2B-with-picture' />
   */
  public int minScoreTriangulation(int[] A) {
    return minScoreTriangulation(A, 0, A.length - 1);
  }

  private int minScoreTriangulation(final int[] A, final int i, final int j) {
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
//    if (i + 2 == j) {
//      return A[i] * A[i + 1] * A[j];
//    }
    int min = 0;
    for (int k = i + 1; k < j; ++k) {
      min = Math.min(min == 0 ? Integer.MAX_VALUE : min,
          minScoreTriangulation(A, i, k)
              + A[i] * A[j] * A[k]
              + minScoreTriangulation(A, k, j));
    }
    dp[i][j] = min;
    return min;
  }
}
