package _001_050._041_First_Missing_Positive;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
public class Solution {

  /**
   * Given an unsorted integer array, find the first missing positive integer.
   * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    int[] indexToFill = new int[nums.length + 1]; //max is nums.length - 1
    Arrays.fill(indexToFill, -1);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0 && nums[i] < indexToFill.length) {
        indexToFill[nums[i]] = 1;
      }
    }

    for (int i = 1; i < indexToFill.length; i++) {
      if (indexToFill[i] < 0) {
        return i;
      }
    }
    // nums are 1 -> nums.length;
    return nums.length + 1;
  }
}
