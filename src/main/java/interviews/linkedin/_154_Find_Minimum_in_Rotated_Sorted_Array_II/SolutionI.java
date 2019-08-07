package interviews.linkedin._154_Find_Minimum_in_Rotated_Sorted_Array_II;

public final class SolutionI implements Solution {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == nums[right]) {
        right--;
      } else if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }
}
