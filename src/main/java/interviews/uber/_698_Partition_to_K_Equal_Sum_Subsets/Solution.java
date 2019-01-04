package interviews.uber._698_Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;

public class Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    final int sum = getSum(nums);
    if (k <= 1) {
      return true;
    }
    if (sum % k != 0) {
      return false;
    }
    final int target = sum / k;
    Arrays.sort(nums);
    for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
      swap(nums, i, j);
    }
    return dfs(nums, new boolean[nums.length], target, 0, k, 0);
  }

  private static boolean dfs(final int[] nums, final boolean[] visited, final int target,
                             final int start, final int remainK, final int curSum) {
    if (remainK == 1) {
      return true;
    }

    if (curSum > target) {
      return false;
    }

    if (curSum == target) {
      return dfs(nums, visited, target, 0, remainK - 1, 0);
    }
    if (start == nums.length) {
      return false;
    }

    for (int i = start; i < nums.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      if (dfs(nums, visited, target, i, remainK, curSum + nums[i])) {
        return true;
      }
      visited[i] = false;
    }
    return false;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    int tmp = nums[j];
    nums[j] = nums[i];
    nums[i] = tmp;
  }

  private static int getSum(final int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    return sum;
  }
}
