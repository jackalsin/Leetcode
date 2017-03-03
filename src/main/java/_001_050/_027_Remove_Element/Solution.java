package _001_050._027_Remove_Element;

/**
 * @author jacka
 * @version 1.0 on 1/24/2017.
 */
public class Solution {
  /**
   * Given an array and a value, remove all instances of that value in place and return the new
   * length.
   * Do not allocate extra space for another array, you must do this in place with constant memory.
   * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else {
      int cur = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
          nums[cur++] = nums[i];
        }
      }
      return cur;
    }
  }
}
