package interviews.linkedin._031_Next_Permutation;

public final class SolutionI implements Solution {

  public void nextPermutation(int[] nums) {
    int lastMax = 0, swapIndex = 0;
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i - 1] < nums[i]) {
        lastMax = i;
      }

      if (lastMax != 0 && nums[i] > nums[lastMax - 1]) {
        swapIndex = i;
      }
    }

    if (lastMax == 0) {
      reverse(nums, 0, nums.length - 1);
    } else {
      assert swapIndex != 0;
      swap(nums, swapIndex, lastMax - 1);
      reverse(nums, lastMax, nums.length - 1);
    }
  }

  private static void reverse(final int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      j--;
      i++;
    }

  }

  private static void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
