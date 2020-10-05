package _0001_0050._041_First_Missing_Positive;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 09/03/2018
 */
public final class BucketSortSolution implements Solution {

  /**
   * Given an unsorted integer array, find the first missing positive integer.
   * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    final int[] index = new int[nums.length + 1];
    Arrays.fill(index, -1);
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] >= 1 && nums[i] <= nums.length) {
        index[nums[i]] = i;
      }
    }


    for (int i = 1; i < index.length; ++i) {
      if (index[i] == -1) {
        return i;
      }
    }
    return nums.length + 1; // all elements are from 1 to nums.length
  }
}
