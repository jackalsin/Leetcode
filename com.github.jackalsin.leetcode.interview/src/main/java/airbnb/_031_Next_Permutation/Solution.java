package airbnb._031_Next_Permutation;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public class Solution {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int firstDecreasing = nums.length - 2;
    for (; firstDecreasing >= 0; firstDecreasing--) {
      if (nums[firstDecreasing] < nums[firstDecreasing + 1]) {
        break;
      }
    }
    firstDecreasing++;
    if (firstDecreasing == 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    }

    int firstGreater = nums.length - 1;
    for (; firstGreater >= 0; firstGreater--) {
      if (nums[firstGreater] <= nums[firstDecreasing - 1]) continue;
      swap(nums, firstGreater, firstDecreasing - 1);
      break;
    }
    reverse(nums, firstDecreasing, nums.length - 1);
  }

  private static void reverse(final int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
