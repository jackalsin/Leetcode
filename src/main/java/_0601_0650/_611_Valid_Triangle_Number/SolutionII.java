package _0601_0650._611_Valid_Triangle_Number;

import java.util.Arrays;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public final class SolutionII implements Solution {
  public int triangleNumber(int[] nums) {
    if (nums == null || nums.length <= 2) {
      return 0;
    }
    final int n = nums.length;
    Arrays.sort(nums);
    int count = 0;
    for (int i = n - 1; i >= 2; --i) {
      int l = 0, r = i - 1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          count += r - l;
          r--;
        } else {
          ++l;
        }
      }
    }
    return count;
  }
}
