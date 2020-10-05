package linkedin._259_3Sum_Smaller;

import java.util.Arrays;

public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i < nums.length; ++i) {
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        if (nums[i] + nums[j] + nums[k] < target) {
          count += k - j;
          j++;
        } else {
          k--;
        }
      }
    }
    return count;
  }
}
