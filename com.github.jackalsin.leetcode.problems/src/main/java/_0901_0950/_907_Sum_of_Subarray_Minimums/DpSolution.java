package _0901_0950._907_Sum_of_Subarray_Minimums;

/**
 * O(N^2)
 *
 * @author jacka
 * @version 1.0 on 12/15/2019
 */
public final class DpSolution implements Solution {
  @Override
  public int sumSubarrayMins(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int sum = 0;
    final int[] mins = new int[A.length];
    final int n = A.length;
    for (int end = 0; end < n; end++) {
      for (int start = 0; start <= end; ++start) {
        if (start < end) {
          final int min = Math.min(mins[start], A[end]);
          sum = safeAdd(min, sum);
          mins[start] = min;
        } else {
          mins[start] = A[start];
          sum = safeAdd(A[start], sum);
        }
      }
    }
    return sum;
  }

  private static final int MOD = (int) (1E9 + 7);

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }
}
