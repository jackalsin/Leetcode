package interviews.linkedin._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolutionI implements Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ++i) {
      if (i > 0 && nums[i - 1] == nums[i]) continue; // i duplicate
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        final int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          // skip all the duplicates
          while (j + 1 < k && nums[j + 1] == nums[j]) {
            j++;
          }
          j++;
          while (k - 1 > j && nums[k - 1] == nums[k]) {
            k--;
          }
          k--;

        } else if (sum < 0) {
          j++;
        } else {
          --k;
        }
      }
    }
    return result;
  }

}
