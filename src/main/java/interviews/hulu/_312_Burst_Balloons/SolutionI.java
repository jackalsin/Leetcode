package interviews.hulu._312_Burst_Balloons;

/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxCoins(int[] nums) {
    final int n = nums.length;
    final int[] newInts = new int[n + 2];
    newInts[0] = newInts[n + 1] = 1;
    System.arraycopy(nums, 0, newInts, 1, n);
    final int[][] memo = new int[n + 2][n + 2];

    final int res = maxCoins(memo, newInts, 1, n);
//    display(memo);
    return res;
  }

  private static int maxCoins(final int[][] memo, final int[] nums, final int left, final int right) {
    if (left == right) {
      final int res = nums[left - 1] * nums[left] * nums[left + 1];
      memo[left][right] = res;
      return res;
    }
    if (memo[left][right] > 0) {
      return memo[left][right];
    }
    int max = 0;
    for (int i = left; i <= right; ++i) {
      max = Math.max(max, nums[left - 1] * nums[i] * nums[right + 1]
          + maxCoins(memo, nums, left, i - 1) + maxCoins(memo, nums, i + 1, right));
    }
    memo[left][right] = max;
    return memo[left][right];
  }
}
