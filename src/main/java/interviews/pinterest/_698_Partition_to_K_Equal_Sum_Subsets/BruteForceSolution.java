package interviews.pinterest._698_Partition_to_K_Equal_Sum_Subsets;

public class BruteForceSolution implements Solution {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    long sum = 0L;
    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }

    return canPartitionKSubsets(nums, k, sum / k, new boolean[nums.length], 0, 0);
  }

  private static boolean canPartitionKSubsets(final int[] nums, final int remain, final long target, final boolean[]
      visited, final int curSum, final int start) {
    if (remain == 0) {
      return true;
    }

    for (int i = start; i < nums.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      if (curSum + nums[i] == target) {
        final boolean curRes = canPartitionKSubsets(nums, remain - 1, target, visited, 0, 0);
        if (curRes) {
          return true;
        }
      } else if (curSum + nums[i] < target) {
        final boolean curRes = canPartitionKSubsets(nums, remain, target, visited, curSum + nums[i], i + 1);
        if (curRes) {
          return true;
        }
      }
      visited[i] = false;
    }

    return false;
  }
}
