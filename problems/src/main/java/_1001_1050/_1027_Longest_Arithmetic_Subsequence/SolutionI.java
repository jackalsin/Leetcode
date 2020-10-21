package _1001_1050._1027_Longest_Arithmetic_Subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/20/2020
 */
public final class SolutionI implements Solution {

  public int longestArithSeqLength(int[] A) {
    assert A.length >= 2;
    final int n = A.length;
    final Map<Integer, Integer>[] dp = new HashMap[n];
    int max = 2;
    for (int j = 0; j < n; ++j) {
      dp[j] = new HashMap<>();
      for (int i = 0; i < j; ++i) {
        final int d = A[j] - A[i],
            curLen = dp[i].getOrDefault(d, 1) + 1;
        max = Math.max(max, curLen);
        dp[j].put(d, curLen);
      }
    }
    return max;
  }
}
