package interviews.airbnb._300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[] tails = new int[nums.length];
    tails[0] = nums[0];
    int right = 0;
    for (int i = 1; i < nums.length; i++) {
      int insertIndex = Arrays.binarySearch(tails, 0, right + 1, nums[i]);
      if (insertIndex < 0) {
        insertIndex = -(insertIndex + 1);
      }
      if (insertIndex > right) {
        right++;
      }
      tails[insertIndex] = nums[i];
    }
    return right + 1;
  }
}
