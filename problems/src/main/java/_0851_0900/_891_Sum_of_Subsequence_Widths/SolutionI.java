package _0851_0900._891_Sum_of_Subsequence_Widths;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int sumSubseqWidths(int[] A) {
    /*For each number A[i]:
     * There are i smaller numbers,
     * so there are 2 ^ i sequences in which A[i] is maximum.
     * we should do res += A[i] * (2 ^ i)

     * There are n - i - 1 bigger numbers,
     * so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
     * we should do res -= A[i] * (n - i - 1)
     */
    Arrays.sort(A);
    long result = 0;
    final int n = A.length;
    long c = 1;
    for (int i = 0; i < n; ++i, c = c * 2 % MOD) {
      result = (result + A[i] * c - A[n - i - 1] * c) % MOD;
    }
    return (int) ((result + MOD) % MOD);
  }

}
