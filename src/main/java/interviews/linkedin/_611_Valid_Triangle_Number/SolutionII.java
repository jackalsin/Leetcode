package interviews.linkedin._611_Valid_Triangle_Number;

import java.util.Arrays;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public final class SolutionII implements Solution {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = nums.length - 1; i >= 0; --i) {
      final int max = nums[i];
      int left = 0, right = i - 1;
      while (left < right) {
        if (nums[left] + nums[right] > max) {
          count += (right - left);
          right--;
        } else {
          left++;
        }
      }
    }
    return count;
  }

}
