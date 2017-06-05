package _051_100._075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 5/11/2017.
 */
public class Solution {
  public void sortColors(int[] nums) {
    int left = 0, right = nums.length - 1;
    for (int i = 0; i <= right; i++) {
      while (nums[i] == 2 && i < right) swap(nums, i, right--);
      while (nums[i] == 0 && i > left) swap(nums, i, left++);
    }
  }

  static void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}
