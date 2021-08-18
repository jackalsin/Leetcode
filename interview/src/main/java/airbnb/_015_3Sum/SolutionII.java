package airbnb._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/16/2021
 */
public final class SolutionII implements Solution {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) return Collections.emptyList();
    final int n = nums.length;
    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1, k = n - 1; j < k; ) {
        final long sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          result.add(List.of(nums[i], nums[j], nums[k]));
        }
        if (sum <= 0) {
          while (j < k && nums[j] == nums[j + 1]) ++j;
          ++j;
        }
        if (sum >= 0) {
          while (j < k && nums[k] == nums[k - 1]) --k;
          --k;
        }
      }
      while (i + 1 < n && nums[i] == nums[i + 1]) ++i;
    }
    return result;
  }
}
