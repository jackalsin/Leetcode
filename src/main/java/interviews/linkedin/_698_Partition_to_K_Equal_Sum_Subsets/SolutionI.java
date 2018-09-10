package interviews.linkedin._698_Partition_to_K_Equal_Sum_Subsets;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionI implements Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }
    int perSum = sum / k;

    return canPartitionKSubsets(nums, new boolean[nums.length], k, 0, perSum, 0, 0);
  }

  /**
   * With index, it take 1690 ms, with: 15 ms
   */
  private boolean canPartitionKSubsets(final int[] nums, final boolean[] visited, int totalCount,
                                       int curCount, int ave, int curSum, int startIndex) {
    if (totalCount == 1) {
      return true;
    }
    if (curSum > ave) {
      return false;
    } else if (ave == curSum) {
      curCount++;
      if (curCount + 1 == totalCount) {
        return true;
      } else {
        return canPartitionKSubsets(nums, visited, totalCount, curCount, ave, 0, 0);
      }
    } else {
      for (int i = startIndex; i < nums.length; ++i) {
        if (!visited[i]) {
          visited[i] = true;
          if (canPartitionKSubsets(nums, visited, totalCount, curCount, ave, curSum + nums[i],
              i + 1)) {
            return true;
          }
          visited[i] = false;
        }
      }
      return false;
    }
  }
}
