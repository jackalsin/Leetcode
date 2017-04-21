package _051_100._053_Maximum_Subarray;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/27/2017.
 */
public class Solution {

  public int maxSubArray(int[] nums) {
    if (nums == null) {
      throw new NullPointerException();
    }
    if (nums.length == 0) {
      throw new IllegalArgumentException("nums cannot be an empty one");
    }
    int maxEndingHere = nums[0];
    int maxSofar = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
      maxSofar = Math.max(maxSofar, maxEndingHere);
    }
    return maxSofar;
  }
}
