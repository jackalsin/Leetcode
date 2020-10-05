package oracle._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length <= 2) {
      return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        final long sum = nums[i] + (long) nums[j] + nums[k];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          while (j < k && nums[k] == nums[k - 1]) k--;
          k--;
          while (j < k && nums[j] == nums[j + 1]) ++j;
          ++j;
        } else if (sum > 0) {
          while (j < k && nums[k] == nums[k - 1]) k--;
          k--;
        } else {
          while (j < k && nums[j] == nums[j + 1]) ++j;
          ++j;
        }
      }
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
    }
    return result;
  }
}
