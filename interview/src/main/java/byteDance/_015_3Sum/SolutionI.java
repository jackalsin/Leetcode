package byteDance._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    final int n = nums.length;
    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        final int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          result.add(List.of(nums[i], nums[j], nums[k]));
        }
        if (sum >= 0) {
          while (k > 0 && nums[k - 1] == nums[k]) {
            k--;
          }
          k--;
        }
        if (sum <= 0) {
          while (j < n - 1 && nums[j] == nums[j + 1]) j++;
          j++;
        }
      } // end of [j, k]
      while (i + 1 < n && nums[i] == nums[i + 1]) ++i;
    }
    return result;
  }
}
