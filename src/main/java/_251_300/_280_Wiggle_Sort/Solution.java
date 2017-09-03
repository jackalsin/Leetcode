package _251_300._280_Wiggle_Sort;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/3/2017.
 */
public class Solution {
  /**
   * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <=
   * nums[3]....
   * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
   * @param nums
   */
  public void wiggleSort(int[] nums) {
//    nLogNSolution(nums);
    oNSolution(nums);
  }

  private void oNSolution(int[] nums) {
    for(int i = 0; i < nums.length; ++i) {
      if (i % 2 == 1) {
        if (nums[i - 1] > nums[i]) swap(nums, i, i - 1);
      } else {
        if (i!= 0 && nums[i] > nums[i - 1]) swap(nums, i, i - 1);
      }
    }
  }

  private void nLogNSolution(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i + 2 < nums.length; i += 2) {
      swap(nums, i + 1, i + 2);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
