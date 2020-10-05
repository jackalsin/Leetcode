package _0951_1000._985_Sum_of_Even_Numbers_After_Queries;

import java.util.Arrays;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    if (queries == null || queries.length == 0) {
      return new int[0];
    }
    final int n = queries.length;
    final int[] result = new int[n];
    int curEvenSum = Arrays.stream(A).filter(x -> x % 2 == 0).sum();
    for (int i = 0; i < n; ++i) {
      final int toAdd = queries[i][0], index = queries[i][1],
          prev = A[index];
      if (prev % 2 == 0) {
        curEvenSum -= prev;
      }
      A[index] += toAdd;
      if (A[index] % 2 == 0) {
        curEvenSum += A[index];
      }
      result[i] = curEvenSum;
    }
    return result;
  }
}
