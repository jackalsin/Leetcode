package interviews.microsoft.noodleEssence._075_Sort_Colors;

public class Solution {
  public void sortColors(int[] nums) {
    int left = 0, right = nums.length - 1;
    for (int i = 0; i <= right; i++) {
      while (nums[i] == 2 && i <= right) {
        swap(nums, i, right--);
      }
      while (nums[i] == 0 && i >= left) {
        swap(nums, i, left++);
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    int tmp = nums[j];
    nums[j] = nums[i];
    nums[i] = tmp;
  }
}
