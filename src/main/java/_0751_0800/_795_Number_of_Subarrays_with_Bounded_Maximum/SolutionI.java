package _0751_0800._795_Number_of_Subarrays_with_Bounded_Maximum;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int n = A.length;
    final int[] dp = new int[n];
    int count = 0;
    int startIndex = 0;
    for (int i = 0; i < n; ++i) {
      if (A[i] < L) {
        if (i > 0) {
          dp[i] = dp[i - 1];
        }
      } else if (A[i] > R) {
        startIndex = i + 1;
      } else {
        assert L <= A[i] && A[i] <= R;
        dp[i] = (i - startIndex + 1);
      }
      count += dp[i];
    }
    return count;
  }
}
