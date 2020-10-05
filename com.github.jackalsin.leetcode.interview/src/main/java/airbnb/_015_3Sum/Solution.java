package airbnb._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        final int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          while (left < right && nums[left] == nums[left - 1]) left++;
          right--;
          while (left < right && nums[right] == nums[right + 1]) right--;
        } else if (sum > 0) {
          right--;
          while (left < right && nums[right] == nums[right + 1]) right--;
        } else {
          left++;
          while (left < right && nums[left] == nums[left - 1]) left++;
        }
      }
    }
    return result;
  }
}
