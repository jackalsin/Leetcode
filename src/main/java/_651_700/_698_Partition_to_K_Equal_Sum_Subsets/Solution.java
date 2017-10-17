package _651_700._698_Partition_to_K_Equal_Sum_Subsets;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    assert 1 <= k && k <= 16;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum < k) {
      return false;
    }
    if (sum % k != 0) {
      return false;
    }
    int perSum = sum / k;

    final boolean[] visited = new boolean[nums.length];
//    return canPartitionKSubsets(nums, visited, perSum, k, 0, 0, 0, 0);
    return canPartitionKSubsetsImproved(nums, visited, perSum, k, 0, 0, 0, 0);
  }

  private boolean canPartitionKSubsets(final int[] nums, final boolean[] visited, final int sum,
                                       final int k, int groupCount, int totalUsed, int curSum, int
                                           startIndex) {
    if (k == 1) {
      return true;
    }
    /*
     * if we arrange conditions as order of 1, 2, 3
     * The last group whose <tt>sum == curSum</tt> won't count into <tt>groupCount</tt>
     */
    // condition 2:
    if (curSum > sum) {
      return false;
    }
    // condition 3
    if (sum == curSum) {
      return canPartitionKSubsets(nums, visited, sum, k, groupCount + 1, totalUsed, 0, 0);
    }

    // condition 1:
    if (totalUsed == nums.length) {
      return k == groupCount;
    }

    for (int i = startIndex; i < nums.length; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        if (canPartitionKSubsets(nums, visited, sum, k, groupCount, totalUsed + 1,
            curSum + nums[i], i + 1)) {
          return true;
        }
        visited[i] = false;
      }
    }
    return false;
  }

  private boolean canPartitionKSubsetsImproved(final int[] nums, final boolean[] visited, final int
      sum, final int k, int groupCount, int totalUsed, int curSum, int startIndex) {
    if (k == 1) {
      return true;
    }

    // condition 1:
    if (totalUsed == nums.length) {
      return k == groupCount;
    }

    for (int i = startIndex; i < nums.length; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        if (curSum + nums[i] == sum) {
          return canPartitionKSubsets(nums, visited, sum, k, groupCount + 1,
              totalUsed + 1, 0, 0);
        } else if (curSum + nums[i] < sum) {
          if (canPartitionKSubsets(nums, visited, sum, k, groupCount, totalUsed + 1,
              curSum + nums[i], i + 1)) {
            return true;
          }
        }
        visited[i] = false;
      }
    }
    return false;
  }
}

