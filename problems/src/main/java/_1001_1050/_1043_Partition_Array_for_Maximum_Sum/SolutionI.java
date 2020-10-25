package _1001_1050._1043_Partition_Array_for_Maximum_Sum;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSumAfterPartitioning(int[] A, int K) {
    final int n = A.length;
    final int[] dp = new int[n + 1];
    for (int i = 0, max = 0; i < K; ++i) {
      max = Math.max(max, A[i]);
      dp[i + 1] = (i + 1) * max;
    }
    for (int right = K; right < n; ++right) {
      int max = 0;
      for (int left = right, maxInWindow = A[right]; left >= right - K + 1; --left) {
        maxInWindow = Math.max(maxInWindow, A[left]);
        int cur = dp[left] + maxInWindow * (right - left + 1);
        max = Math.max(cur, max);
      }
      dp[right + 1] = max;
    }
//    System.out.println(Arrays.toString(dp));
    return dp[n];
  }
}
