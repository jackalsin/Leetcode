package _151_200._154_Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 7/16/2017.
 */
public class Solution {
  public int findMin(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
      int mid = (end - start) / 2 + start;
      if(nums[start] < nums[mid]) {
        start = mid + 1;
      } else if (nums[start] > nums[mid]) {
        start = mid;
      } else {
        start++;
      }
    }
    return nums[start];
  }
}
