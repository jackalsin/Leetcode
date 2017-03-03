package _001_050._035_Search_Insert_Position;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
public class Solution {
  /**
   * Given a sorted array and a target value, return the index if the target is found. If not,
   * return the index where it would be if it were inserted in order.
   *
   * @param nums    a sorted array without duplicated element.
   * @param target  target value to find.
   * @return        the index if the target is found otherwise the index where it would be if it
   *                were inserted in order.
   */
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
