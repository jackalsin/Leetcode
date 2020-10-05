package linkedin._698_Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;


/**
 * @author jacka
 * @version 1.0 on 7/26/2019
 */
public final class SolutionIV implements Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    assert k > 0;
    if (nums == null || nums.length < k) {
      return false;
    }
    final long sum = getSum(nums);
    if (sum % k != 0) {
      return false;
    }
    final long target = sum / k;
    Arrays.sort(nums);
    reverse(nums);
    return canPartitionKSubsets(nums, k, target, target, new boolean[nums.length], nums.length, 0);
  }

  private static void reverse(final int[] nums) {
    for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
      swap(nums, left, right);
    }
  }

  private static void swap(final int[] nums, final int left, final int right) {
    final int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }

  private static boolean canPartitionKSubsets(final int[] nums, final int k, final long target,
                                              final long remain, boolean[] visited,
                                              final int notUsedCount, final int start) {
    if (k == 1) {
      return true;
    }
    if (remain < 0) {
      return false;
    }
    if (remain == 0) {
      return notUsedCount != 0 && canPartitionKSubsets(nums, k - 1, target, target, visited, notUsedCount, 0);
    }

    for (int i = start; i < nums.length; i++) {
      if (visited[i] /*|| nums[i] > remain*/) continue;
      visited[i] = true;
      final boolean res = canPartitionKSubsets(nums, k, target, remain - nums[i], visited, notUsedCount - 1, i + 1);
      if (res) {
        visited[i] = false;
        return true;
      }
      visited[i] = false;
    }
    return false;
  }

  private static long getSum(final int[] nums) {
    long sum = 0;
    for (int n : nums) {
      sum += n;
    }
    return sum;
  }
}
