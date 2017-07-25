package _151_200._162_Find_Peak_Element;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/23/2017.
 */
public class Solution {
  public int findPeakElement(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
      int mid = (end - start) / 2 + start;
      if (nums[mid] < nums[mid + 1]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }
}
