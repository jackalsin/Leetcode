package _0901_0950._908_Smallest_Range_I;

/**
 * @author jacka
 * @version 1.0 on 9/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int smallestRangeI(int[] A, int K) {
    if (A.length <= 1) return 0;
    int min = A[0], max = A[0];
    for (int i = 1; i < A.length; ++i) {
      min = Math.min(min, A[i]);
      max = Math.max(max, A[i]);
    }
    return Math.max(0, max - min - 2 * K);
  }
}
