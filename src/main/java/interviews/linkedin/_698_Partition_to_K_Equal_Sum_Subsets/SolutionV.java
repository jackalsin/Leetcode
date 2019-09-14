package interviews.linkedin._698_Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class SolutionV implements Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    if (nums == null || nums.length < k) {
      return false;
    }
    final long sum = getSum(nums);
    if (sum % k != 0) {
      return false;
    }
    final long target = sum / k;
    final boolean[] visited = new boolean[nums.length];
    Arrays.sort(nums);
    reverse(nums);
    return canPartitionSubsets(nums, k, target, 0, visited, 0);
  }

  private static boolean canPartitionSubsets(final int[] nums, final int k, final long target,
                                             final long sum, final boolean[] visited, final int start) {
    if (sum > target) {
      return false;
    }
    if (sum == target) {
      if (k == 1) {
        return true;
      }
      return canPartitionSubsets(nums, k - 1, target, 0, visited, 0);
    }
    for (int i = start; i < nums.length; ++i) {
      if (visited[i]) continue;
      visited[i] = true;
      final boolean res = canPartitionSubsets(nums, k, target, sum + nums[i], visited, i + 1);
      if (res) {
        visited[i] = false;
        return true;
      }
      visited[i] = false;
    }
    return false;
  }

  private static long getSum(final int[] nums) {
    long res = 0;
    for (int n : nums) {
      res += n;
    }
    return res;
  }

  private static void reverse(final int[] nums) {
    for (int left = 0, right = nums.length - 1; left < right; ++left, --right) {
      final int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
    }
  }
}
