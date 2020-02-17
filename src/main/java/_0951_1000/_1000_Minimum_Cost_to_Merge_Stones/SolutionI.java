package _0951_1000._1000_Minimum_Cost_to_Merge_Stones;

/**
 * @author jacka
 * @version 1.0 on 2/16/2020
 */
public final class SolutionI implements Solution {
  private int[] sums;
  private int K;
  private int[][][] dp;

  /**
   * https://leetcode.com/problems/minimum-cost-to-merge-stones/discuss/247657/JAVA-Bottom-Up-%2B-Top-Down-DP-With-Explaination
   */
  public int mergeStones(int[] stones, int K) {
    final int n = stones.length;
    if ((n - 1) % (K - 1) != 0) return -1;
    this.K = K;
    sums = new int[n + 1];
    for (int i = 0; i < n; ++i) {
      sums[i + 1] = sums[i] + stones[i];
    }
    dp = new int[K + 1][n][n];
    final int res = mergeStones(0, n - 1, 1);
//    Arrays.stream(dp).forEach(TwoDimensionArray::display);
    return res;
  }

  /**
   * @param left
   * @param right
   * @param piles piles to merge to
   * @return
   */
  private int mergeStones(final int left, final int right, final int piles) {
    if (dp[piles][left][right] != 0) {
      return dp[piles][left][right];
    }
    int res = Integer.MAX_VALUE;
    if (left == right) {
      res = piles == 1 ? 0 : Integer.MAX_VALUE;
    } else {
      if (piles == 1) {
        final int mergeToK = mergeStones(left, right, K);
        if (mergeToK != Integer.MAX_VALUE) {
          res = mergeToK + getSum(left, right);
        }
      } else {
        for (int mid = left; mid < right; ++mid) {
          final int leftCandidate = mergeStones(left, mid, piles - 1),
              rightCandidate = mergeStones(mid + 1, right, 1);
          if (leftCandidate != Integer.MAX_VALUE && rightCandidate != Integer.MAX_VALUE) {
            res = Math.min(res, leftCandidate + rightCandidate);
          }
        }
      }
    }
    dp[piles][left][right] = res;
    return res;
  }

  private int getSum(final int i, final int j) {
    return sums[j + 1] - sums[i];
  }
}
