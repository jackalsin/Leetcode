package _151_200._188_Best_Time_to_Buy_and_Sell_Stock_IV;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  /**
   * Rotate an array of n elements to the right by k steps.
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }
}
