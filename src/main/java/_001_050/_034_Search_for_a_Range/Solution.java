package _001_050._034_Search_for_a_Range;

/**
 * @author jacka
 * @version 1.0 on 2017/2/8.
 */
public class Solution {

  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] {-1, -1};
    }
    return searchRange(nums, target, 0, nums.length - 1);
  }

  private int[] searchRange(int[] nums, int target, int left, int right) {
    if (nums[left] == target && nums[right] == target) {
      return new int[] {left, right};
    } else if (nums[left] <= target && nums[right] >= target) {
      int mid = left + (right - left) / 2;
      int[] lowers = searchRange(nums, target, 0, mid);
      int[] uppers = searchRange(nums, target, mid + 1, right);
      if (lowers[0] == -1) {
        return uppers;
      } else if (uppers[0] == -1) {
        return lowers;
      } else {
        return new int[] {lowers[0], uppers[1]};
      }
    }
    return new int[] {-1, -1};
  }
}
