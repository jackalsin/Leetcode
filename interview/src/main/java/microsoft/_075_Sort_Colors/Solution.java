package microsoft._075_Sort_Colors;

public class Solution {
  public void sortColors(int[] nums) { // TODO: redo
    if (nums == null || nums.length == 0) {
      return;
    }
    int l = 0, r = nums.length - 1;

    for (int i = 0; i <= r; i++) {
      while (nums[i] == 2 && i < r) {
        swap(nums, i, r--);
      }

      while (nums[i] == 0 && i > l) {
        swap(nums, i, l++);
      }
    }
  }

  private static void swap(final int[] nums, final int i, int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
