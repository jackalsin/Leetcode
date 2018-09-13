package _651_700._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {
  @Override
  public List<Integer> findClosestElements(int[] nums, int k, int x) {
    // The value k is positive and will always be smaller than the length of the sorted array.
    if (k == 0 || nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    int left = 0, right = nums.length - k;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (x - nums[mid] <= nums[mid + k] - x) { // first satisfy
        right = mid;
      } else {
        left = mid + 1;
      }
    }
//    assert (x - nums[left] <= nums[left + k] - x);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      result.add(nums[left + i]);
    }
    return result;
  }

}
