package interviews.linkedin._416_Partition_Equal_Subset_Sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public class Solution {
  public boolean canPartition(int[] nums) {
    final int sum = getSum(nums);
    assert nums.length > 0;
    if (sum % 2 == 1) {
      return false;
    }
    final int target = sum / 2;
    Arrays.sort(nums);
    reverse(nums);
    final Set<Integer> all = new HashSet<>();
    all.add(0);
    if (all.contains(target)) {
      return true;
    }
    for (int num : nums) {
      final Set<Integer> prev = new HashSet<>(all);
      for (int pre : prev) {
        final int newSum = pre + num;
        if (newSum == target) {
          return true;
        } else if (newSum < target) {
          all.add(newSum);
        }
      }
      if (all.contains(target)) {
        return true;
      }
    }

    return false;
  }

  private static void reverse(final int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
      ++left;
      --right;
    }
  }

  private static int getSum(final int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }
}
