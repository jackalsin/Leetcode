package interviews.linkedin._698_Partition_to_K_Equal_Sum_Subsets;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionIII implements Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }

    if (sum % k != 0) {
      return false;
    }

    final int target = sum / k;
    return dfs(nums, target, k, new boolean[nums.length], 0, 0);
  }

  private static boolean dfs(final int[] nums, final int target, int remainGroup, final boolean[] visited,
                             int sum, int startIndex) {
    if (sum > target) {
      return false;
    } else if (sum == target) {
      if (remainGroup == 1) {
        return true;
      }
      return dfs(nums, target, remainGroup - 1, visited, 0, 0);
    }

    for (int i = startIndex; i < nums.length; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        if (dfs(nums, target, remainGroup, visited, sum + nums[i], i + 1)) {
          return true;
        }
        visited[i] = false;
      }
    }
    return false;
  }
}
