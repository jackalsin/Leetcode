package interviews.uber._031_Next_Permutation;

public class Solution {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int pivot = nums.length - 1;

    while (pivot > 0 && nums[pivot] <= nums[pivot - 1]) {
      pivot--;
    }
    if (pivot != 0) {
      for (int j = nums.length - 1; j >= pivot; j--) {
        if (nums[j] > nums[pivot - 1]) {
          swap(nums, j, pivot - 1);
          break;
        }
      }
    }

    reverse(nums, pivot, nums.length - 1);
  }

  private static void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }


  private static void reverse(final int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }
}
