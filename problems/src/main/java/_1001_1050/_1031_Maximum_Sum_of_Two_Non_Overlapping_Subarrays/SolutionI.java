package _1001_1050._1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays;

/**
 * @author zhixi
 * @version 1.0 on 10/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    return Math.max(
        maxSumTwoNoOverlapHelper(A, L, M),
        maxSumTwoNoOverlapHelper(A, M, L)
    );
  }

  /**
   * L is left, M is right;
   * Lsum, sum of the last L elements
   * Msum, sum of the last M elements
   * <p>
   * Lmax, max sum of contiguous L elements before the last M elements.
   * Mmax, max sum of contiguous M elements before the last L elements/
   * <p>
   * Complexity
   */
  private int maxSumTwoNoOverlapHelper(int[] A, int L, int M) {
    int res = 0, LSum = 0, MSum = 0, LMax = 0, MMax = 0;
    for (int i = 0; i < A.length; ++i) {
      MSum += A[i];
      if (i >= M) MSum -= A[i - M];
      if (i >= M) LSum += A[i - M];
      if (i >= L + M) LSum -= A[i - M - L];
      LMax = Math.max(LMax, LSum);
      MMax = Math.max(MMax, MSum);
      res = Math.max(res, LMax + MSum);
    }
    return res;
  }
}
