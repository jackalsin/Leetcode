package microsoft._189_Rotate_Array;

public class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private static void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
      i++;
      j--;
    }
  }
}
