package _451_500._456_132_Pattern;

import java.util.Stack;

/**
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */
public class Solution {
  /**
   * This is looking for 132 pattern, which is 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
   * 也就是说，3 要大于两头，而且2要大于1
   *
   * @param nums
   * @return
   */
  public boolean find132pattern(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    /*
     * dp[0][i] denotes the min value so far.
     * dp[1][i] denotes the max value so far.
     */
    final int[] min = new int[nums.length];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min[i] = Math.min(min[i - 1], nums[i]);
    }

    /*
     * stack is sorted
     *
     * 如果之前sorted，
     * 那么condition 1不满足，显然remain sorted
     * 那么condition 1满足：
     *
     */
    final Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > min[i]) { // condition 1
        // find one greater than min[i]
        while (!stack.isEmpty() && stack.peek() <= min[i]) {
          stack.pop();
        }
//
        if (!stack.isEmpty() && stack.peek() < nums[i]) {
          return true;
        }
        stack.push(nums[i]);
      }
    }
    return false;
  }
}
