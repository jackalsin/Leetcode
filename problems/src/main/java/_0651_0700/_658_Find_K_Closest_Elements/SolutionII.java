package _0651_0700._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {
  @Override
  public List<Integer> findClosestElements(int[] nums, int k, int x) {
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
