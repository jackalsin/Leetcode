package _1251_1300._1262_Greatest_Sum_Divisible_by_Three;

/**
 * @author jacka
 * @version 1.0 on 5/1/2020
 */
public final class DpSolution implements Solution {
  /**
   * @see
   * <a href="https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431077/JavaC%2B%2BPython-One-Pass-O(1)-space">explanation</a>
   */
  @Override
  public int maxSumDivThree(int[] nums) {
    int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int n : nums) {
      final int[] nextDp = new int[3];
      for (int i = 0; i < 3; ++i) {
        nextDp[(i + n) % 3] = Math.max(dp[(i + n) % 3], dp[i] + n);
      }
      dp = nextDp;
    }
    return dp[0];
  }
}
