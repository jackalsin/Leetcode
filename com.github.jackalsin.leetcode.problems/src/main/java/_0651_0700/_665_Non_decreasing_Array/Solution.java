package _0651_0700._665_Non_decreasing_Array;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/29/2017.
 */
public class Solution {
  /**
   * if <code>nums[i] < nums[i - 1]</code> happens, we prefer changing the nums[i - 1] to nums[i
   * - 2] if possible ( when nums[i - 2] exists)
   *
   * if you also find nums[i-2] > nums[i], then you have to change nums[i]'s value instead, or else
   * you need to change both of nums[i-2]'s and nums[i-1]'s values.
   *
   * The example is right here https://discuss.leetcode
   * .com/topic/101115/c-java-clean-code-6-liner-without-modifying-input
   */
  public boolean checkPossibility(int[] nums) {
    int illegalCount = 0;
    for (int i = 1; i < nums.length && illegalCount <= 1; i++) {
      if (nums[i] < nums[i - 1]) {
        illegalCount++;

        if (i - 2 < 0) {
          nums[i - 1] = nums[i];
        } else if (nums[i - 2] <= nums[i]) {
          nums[i - 1] = nums[i - 2];
        } else {
          nums[i] = nums[i - 1];
        }

      }
    }
    System.out.println(Arrays.toString(nums));
    return illegalCount <= 1;
  }
}
