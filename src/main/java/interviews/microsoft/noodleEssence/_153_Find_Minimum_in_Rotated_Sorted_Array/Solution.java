package interviews.microsoft.noodleEssence._153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;

      if (nums[mid] < nums[right]) { // [mid, right] is sorted
        right = mid;
      } else { // nums[mid] > nums[right];
        left = mid + 1;
      }
    }
    return nums[left];
  }
}
