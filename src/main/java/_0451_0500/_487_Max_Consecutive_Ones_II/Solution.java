package _0451_0500._487_Max_Consecutive_Ones_II;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/3/2017.
 */
public class Solution {

  /**
   * Given a binary array, find the maximum number of consecutive 1s in this array if you can
   * flip at most one 0.
   * Example 1:
   * Input: [1,0,1,1,0]
   * Output: 4
   * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
   * After flipping, the maximum number of consecutive 1s is 4.
   *
   * Note:
   * The input array will only contain 0 and 1.
   * The length of input array is a positive integer and will not exceed 10,000
   *
   * Follow up:
   * What if the input numbers come in one by one as an infinite stream? In other words, you can't
   * store all numbers coming from the stream as it's too large to hold in memory. Could you solve
   * it efficiently?
   */
  public int findMaxConsecutiveOnes(int[] nums) {
//    return kEqualsOne(nums);
    return kFollowUp(nums);
//    return streamFollowUp(nums);
  }

  private int kEqualsOne(int[] nums) {
    int count = 0, max = 0;
    return max;
  }

  private int kFollowUp(int[] nums) {
    final int k = 1;
    int zeroCount = 0, max = 0;
    for (int start = 0, end = 0; end < nums.length; end++) {
      if (nums[end] == 0) {
        zeroCount++;
      }
      while (zeroCount > k) { // find next zero
        if (start < nums.length && nums[start++] == 0) {
          zeroCount--;
        }
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }

  private int streamFollowUp(int[] nums) {
    final int k = 1;
    if (nums.length == 0) {
      return 0;
    }
    final Queue<Integer> zeroIndex = new ArrayDeque<>();
    int start = 0, max = 1;
    for (int end = 0; end < nums.length; end++) {
      if (nums[end] == 0) {
        zeroIndex.add(end);
      }

      if (zeroIndex.size() > k) {
        start = zeroIndex.remove() + 1;
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
}
