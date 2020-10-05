package linkedin._698_Partition_to_K_Equal_Sum_Subsets;

public class SolutionIII implements Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) {
      return false;
    }
    final int sum = getSum(nums);
    if (sum % k != 0) {
      return false;
    }
    final int target = sum / k;
    return dfs(nums, k, target, new boolean[nums.length], 0, 0);
  }

  private static boolean dfs(final int[] nums, final int remainK, final int target, final boolean[] visited,
                             final int start, final int sum) {
    if (sum > target) {
      return false;
    } else if (sum == target) {
      if (remainK == 1) {
        return true;
      }
      return dfs(nums, remainK - 1, target, visited, 0, 0);
    }
    for (int i = start; i < nums.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      if (dfs(nums, remainK, target, visited, i + 1, sum + nums[i])) {
        visited[i] = false;
        return true;
      }
      visited[i] = false;
    }
    return false;
  }

  private static int getSum(final int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    return sum;
  }
}
