package interviews.linkedin._611_Valid_Triangle_Number;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/12/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int triangleNumber(int[] nums) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int result = 0;
    for (int k = nums.length - 1; k >= 0; --k) {
      int left = 0, right = k - 1;
      while (left < right) {
        if (nums[left] + nums[right] > nums[k]) {
          result += (right - left);
          --right;
        } else {
          ++left;
        }
      }
    }
    return result;
  }
}
