package _1001_1050._1049_Last_Stone_Weight_II;

/**
 * @author jacka
 * @version 1.0 on 4/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int lastStoneWeightII(int[] stones) {
    /*
    这个题目不错，很有意思，相互碰撞最后会变成 a ± b ± c ± d ...
    本质上就变成了分成两个group的最小diff
    */
    final int SUM = getSum(stones), n = stones.length;
    final boolean[][] dp = new boolean[n][SUM + 1];
    dp[0][0] = true;
    dp[0][stones[0]] = true;
    int max = stones[0];
    for (int i = 1; i < n; ++i) {
      for (int s = 0; s <= SUM / 2; s++) {
        final int stone = stones[i];
        if (dp[i - 1][s] || (s - stone >= 0 && dp[i - 1][s - stone])) {
          dp[i][s] = true;
          max = Math.max(s, max);
        }
      }
    }
    return SUM - 2 * max;
  }

  private int getSum(final int[] stones) {
    if (stones == null || stones.length == 0) {
      return 0;
    }
    int res = 0;
    for (int s : stones) {
      res += s;
    }
    return res;
  }
}
