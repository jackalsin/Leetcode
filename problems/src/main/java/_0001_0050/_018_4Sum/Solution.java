package _0001_0050._018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2017/1/21.
 */
public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length <= 3) {
      return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        for (int j = i + 1; j < nums.length - 2; j++) {
          if (j == i + 1 || nums[j] != nums[j - 1]) {
            int left = j + 1, right = nums.length - 1;
            while (left < right) {
              int sum = nums[i] + nums[j] + nums[left] + nums[right];
              if (sum > target) { //move right
                while (left < right && nums[right] == nums[right - 1]) right--;
                right--;
              } else if (sum < target) {
                while (left < right && nums[left] == nums[left + 1]) left++;
                left++;
              } else {
                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
              }
            }
          }
        }
      }
    }
    return result;
  }
}
