package interviews.microsoft._153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[left] < nums[right]) {
        return nums[left];
      }

      if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return nums[left];
  }

}
