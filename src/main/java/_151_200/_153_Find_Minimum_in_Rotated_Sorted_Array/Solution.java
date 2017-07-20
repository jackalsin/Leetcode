package _151_200._153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 7/16/2017.
 */
public class Solution {
  public int findMin(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
      if (nums[start] < nums[end]) {
        return nums[start];
      }
      int mid = (end - start) / 2 + start;
      if (nums[start] > nums[mid]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return nums[start];
  }
}
