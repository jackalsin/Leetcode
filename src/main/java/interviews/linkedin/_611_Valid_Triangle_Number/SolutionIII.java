package interviews.linkedin._611_Valid_Triangle_Number;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/25/2019
 */
public final class SolutionIII implements Solution {
  public int triangleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int res = 0;
    Arrays.sort(nums);
    for (int k = nums.length - 1; k >= 0; k--) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          res += (j - i);
          j--;
        } else {
          i++;
        }
      }
    }
    return res;
  }
}
