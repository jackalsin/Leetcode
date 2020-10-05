package linkedin._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {
  public List<Integer> findClosestElements(int[] nums, int k, int x) {
    if (nums == null || nums.length == 0 || k >= nums.length || k <= 0) {
      return new ArrayList<>();
    }
    // check zero??
    int left = 0, right = nums.length - k;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (x - nums[mid] <= nums[mid + k] - x) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      result.add(nums[i + left]);
    }
    return result;
  }


}
