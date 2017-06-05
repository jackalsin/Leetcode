package _001_050._026_Remove_Duplicates_from_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 2017/1/23.
 */
public class Solution {
  /**
   * Given a sorted array, remove the duplicates in place such that each element appear only once
   * and return the new length. Do not allocate extra space for another array, you must do this in
   * place with constant memory.
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else {
      int cur = 0;
      for (int i = 0; i < nums.length; i++) {
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
          nums[cur] = nums[i];
          cur++;
        }
      }
      return cur;
    }
  }
}
