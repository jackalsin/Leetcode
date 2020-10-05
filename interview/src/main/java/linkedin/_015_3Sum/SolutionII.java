package linkedin._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/2/2019
 */
public final class SolutionII implements Solution {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        final int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left + 1 < right && nums[left + 1] == nums[left]) {
            left++;
          }
          while (right - 1 > left && nums[right - 1] == nums[right]) {
            right--;
          }
        }
        if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}
