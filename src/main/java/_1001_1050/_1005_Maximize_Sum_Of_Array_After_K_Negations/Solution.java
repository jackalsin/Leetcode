package _1001_1050._1005_Maximize_Sum_Of_Array_After_K_Negations;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
public final class Solution {
  public int largestSumAfterKNegations(int[] A, int K) {
    Arrays.sort(A);
    for (int i = 0; i < A.length && K > 0 && A[i] < 0; i++, K--) {
      A[i] = -A[i];
    }
    int sum = 0, min = Integer.MAX_VALUE;
    for (int a : A) {
      sum += a;
      min = Math.min(min, a);
    }

    K %= 2;
    return sum - (K == 0 ? 0 : 2 * min);
  }
}
