package linkedin._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class BinarySearchSolution implements Solution {
  @Override
  public List<Integer> findClosestElements(int[] nums, int k, int x) {
    final List<Integer> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    int left = 0, right = nums.length - k;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (x - nums[mid] <= nums[mid + k] - x) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    for (int i = left; i < left + k; ++i) {
      result.add(nums[i]);
    }
    return result;
  }
}
