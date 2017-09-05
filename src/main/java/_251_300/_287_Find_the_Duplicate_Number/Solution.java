package _251_300._287_Find_the_Duplicate_Number;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class Solution {
  /**
   * Given an array nums containing n + 1 integers where each integer is between 1 and n
   * (inclusive), prove that at least one duplicate number must exist. Assume that there is only
   * one duplicate number, find the duplicate one.
   * Note:
   * You must not modify the array (assume the array is read only).
   * You must use only constant, O(1) extra space.
   * Your runtime complexity should be less than O(n2).
   * There is only one duplicate number in the array, but it could be repeated more than once.
   * @param nums
   * @return
   */
  public int findDuplicate(int[] nums) {
    return binarySearchLike(nums);
//    return hasCycleLike(nums);
  }

  private int binarySearchLike(int[] nums) {
    int start = 1, end = nums.length - 1;
    while (start < end) {
      int midCount = 0,  mid = (end - start) / 2 + start;
      for (int num : nums) {
        if (num > mid) midCount++;
      }

      if (midCount > (nums.length - 1 - mid)) start = mid + 1;
      else end = mid;
    }
    return start;
  }

  private int hasCycleLike(int[] nums) {
    throw new IllegalStateException("No dup is found");
  }
}
