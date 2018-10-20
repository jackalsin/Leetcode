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
    for (int end = nums.length - 1; end >= 2; end--) {
      int i = 0, j = end - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[end]) {
          count += j - i;
          j--;
        } else {
          i++;
        }
      }
    }
    return count;
  }

}
