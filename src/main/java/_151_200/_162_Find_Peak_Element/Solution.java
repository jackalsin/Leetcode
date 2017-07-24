package _151_200._162_Find_Peak_Element;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/23/2017.
 */
public class Solution {
  public int findPeakElement(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        if (i + 1 >= nums.length || (i + 1 < nums.length && nums[i] > nums[i + 1])) {
          return i;
        }
      } else if (i == nums.length - 1) {
        if (nums[i] > nums[i - 1]) {
          return i;
        }
      } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
       return i;
      }
    }
    throw new IllegalStateException("No peak is found.");
  }
}
