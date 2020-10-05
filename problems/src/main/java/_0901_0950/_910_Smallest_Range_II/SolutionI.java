package _0901_0950._910_Smallest_Range_II;

import java.util.Arrays;

/**
 * @author zhixi
 * @version 1.0 on 9/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int smallestRangeII(int[] A, final int K) {
    /*
    1) 选择（-K，+K） 和 （0， 2*K）是一样的
    2) 如果在sorted array中，如果 i + 1 选择 + 2k，而 i没选择，那么必然拖后腿，因为最大值不会变，而最小值一定会小或者等于
    */
    Arrays.sort(A);
    final int len = A.length;
    int max = A[len - 1], min = A[0], result = max - min;
    for (int i = 0; i < len - 1; ++i) {
      max = Math.max(max, A[i] + 2 * K);
      min = Math.min(A[0] + 2 * K, A[i + 1]);
      result = Math.min(result, max - min);
    }
    return result;
  }
}
