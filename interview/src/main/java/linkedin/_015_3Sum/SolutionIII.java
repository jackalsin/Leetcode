package linkedin._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>();
    final int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int left = i + 1, right = n - 1; left < right; ) {
        final long sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(List.of(nums[i], nums[left], nums[right]));
        }
        if (sum >= 0) {
          while (left < right && nums[right - 1] == nums[right]) right--;
          right--;
        }
        if (sum <= 0) {
          while (left < right && nums[left] == nums[left + 1]) left++;
          left++;
        }
      } // end of for left, right
      while (i + 1 < n && nums[i] == nums[i + 1]) i++;
    }
    return result;
  }
}
