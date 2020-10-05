package _0851_0900._873_Length_of_Longest_Fibonacci_Subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int lenLongestFibSubseq(int[] A) {
    final int n = A.length;
    assert n >= 3;
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      valToIndex.put(A[i], i);
    }
    final int[][] dp = new int[n][n];
    int max = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        max = Math.max(dp[i][j], max);
        final int prev1 = A[i], prev2 = A[j], sum = prev1 + prev2;
        if (valToIndex.containsKey(sum)) {
          final int sumIndex = valToIndex.get(sum);
          dp[j][sumIndex] = Math.max(dp[i][j] + 1, Math.max(dp[j][sumIndex], 3));
        }
      }
    }
//    TwoDimensionArray.println(dp);
    return max;
  }
}
