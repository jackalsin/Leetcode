package _0351_0400._376_Wiggle_Subsequence;

public class Solution {
  private static final int UP = 0, DOWN = 1;

  /**
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   *
   * @param nums
   * @return
   * @see <a href="https://jackalsin.gitbooks.io/algorithm/content/leetcode-solution/376.html">Proof of the algorithm correctness.</a>
   */
  public int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[][] dp = new int[2][nums.length];
    dp[0][0] = 1;
    dp[1][0] = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        dp[UP][i] = dp[DOWN][i - 1] + 1;
        dp[DOWN][i] = dp[DOWN][i - 1];
      } else if (nums[i] < nums[i - 1]) {
        dp[DOWN][i] = dp[UP][i - 1] + 1;
        dp[UP][i] = dp[UP][i - 1];
      } else {
        dp[UP][i] = dp[UP][i - 1];
        dp[DOWN][i] = dp[DOWN][i - 1];
      }
    }
    return Math.max(dp[UP][nums.length - 1], dp[DOWN][nums.length - 1]);
  }
}
