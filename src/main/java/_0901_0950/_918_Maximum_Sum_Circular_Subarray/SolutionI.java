package _0901_0950._918_Maximum_Sum_Circular_Subarray;

/**
 * @author jacka
 * @version 1.0 on 5/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSubarraySumCircular(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int sum = A[0], min = A[0], max = A[0], minEndHere = A[0], maxEndHere = A[0];
    for (int i = 1; i < A.length; ++i) {
      sum += A[i];
      maxEndHere = Math.max(A[i], maxEndHere + A[i]);
      max = Math.max(max, maxEndHere);
      minEndHere = Math.min(A[i], minEndHere + A[i]);
      min = Math.min(min, minEndHere);
    }
    // if all numbers are negative, <tt>sum</tt> will be equal to <tt>min</tt>
    // in this case, we return max(A)
    return sum == min ? max : Math.max(max, sum - min);
  }
}
