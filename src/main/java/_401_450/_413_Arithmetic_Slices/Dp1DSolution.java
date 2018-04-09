package _401_450._413_Arithmetic_Slices;

import java.util.Arrays;

public final class Dp1DSolution implements Solution {
  /**
   * Time Complexity: O(N)
   * <p>
   * 15 / 15 test cases passed.
   * Status: Accepted
   * Runtime: 2 ms
   *
   * @param A
   * @return
   */
  public int numberOfArithmeticSlices(int[] A) {
    if (A == null || A.length < 3) {
      return 0;
    }
    final int[] dp = new int[A.length];
    int res = 0;

    for (int i = 2; i < A.length; i++) {
      if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
        dp[i] = dp[i - 1] + 1;
        res += dp[i];
      }
    }

    return res;
//    return Arrays.stream(dp).sum();
  }
}
