package facebook._075_Sort_Color;

public class Solution {

  public void sortColors(int[] nums) {
    int zeroPtr = 0, twoPtr = nums.length - 1;
    for (int i = 0; i <= twoPtr; i++) {
      while (i < twoPtr && nums[i] == 2) {
        swap(nums, i, twoPtr--);
      }
      while (i > zeroPtr && nums[i] == 0) {
        swap(nums, i, zeroPtr++);
      }
    }
  }

  private static void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
