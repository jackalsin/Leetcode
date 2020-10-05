package linkedin._698_Partition_to_K_Equal_Sum_Subsets;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionII implements Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }
    final int target = sum / k;
    return dfs(nums, new boolean[nums.length], target, k, 0, 0);
  }

  private static boolean dfs(final int[] nums, final boolean[] used, final int target, int remainK, int curSum,
                             int startIndex) {
    if (curSum > target) {
      return false;
    } else if (curSum == target) {
      if (remainK == 1) {
        return true;
      }
      return dfs(nums, used, target, remainK - 1, 0, 0);
    }

    for (int i = startIndex; i < nums.length; ++i) {
      if (used[i]) continue;
      used[i] = true;
      if (dfs(nums, used, target, remainK, curSum + nums[i], i + 1)) {
        used[i] = false;
        return true;
      }
      used[i] = false;
    }
    return false;
  }
}
