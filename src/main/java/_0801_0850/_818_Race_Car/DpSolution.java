package _0801_0850._818_Race_Car;

public final class DpSolution implements Solution {
  /**
   * Time Complexity: O(log(target) ^ 2)
   */
  public int racecar(int target) {
    final int[] dp = new int[10001];
    return racecar(dp, target);
  }

  private static int racecar(final int[] dp, final int target) {
    if (dp[target] > 0) {
      return dp[target];
    }
    // how many bits in <code>target</code>
    // also, it means how many A steps are needed.
    final int n = (int) (Math.log(target) / Math.log(2)) + 1;
    if ((1 << n) == target + 1) {
      dp[target] = n;
    } else {
      // 1. we can go to 2^n - 1 first, then we turn
      dp[target] = n + 1 + racecar(dp, (1 << n) - 1 - target);

      // 2. we can go to 2^(n - 1) - 1, then, we run, go <tt>m</tt> steps
      // then, we turn again, call recursion again
      for (int m = 0; m < n - 1; m++) {
        dp[target] = Math.min(dp[target],
            n - 1 + 1 + m + 1 + racecar(dp, target - ((1 << (n - 1)) - (1 << m)))
//            racecar(dp, target - (1 << (n - 1)) + (1 << m)) + n + m + 1
        );
      }
    }
    return dp[target];
  }
}
