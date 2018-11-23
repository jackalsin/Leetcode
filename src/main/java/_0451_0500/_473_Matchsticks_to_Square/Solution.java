package _0451_0500._473_Matchsticks_to_Square;

import java.util.*;

public class Solution {

  /**
   * 174 / 174 test cases passed.
   * Status: Accepted
   * Runtime: 389 ms
   * Runtime: 389 ms
   *
   * @param nums
   * @return
   */
  public boolean makesquare(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (sum % 4 == 0) {

      Arrays.sort(nums);
      return makesquare(nums, sum / 4, new boolean[nums.length], 0, new ArrayList<>(), 0, nums.length - 1);
    }
    return false;
  }

  private static boolean makesquare(final int[] nums, final int target, final boolean[] visited, final int curSum,
                                    final List<Integer> curPath, final int sides, final int start) {
    if (sides == 4) {
      return true;
    }

    final Set<Integer> checkedOnThisPath = new HashSet<>();
    for (int i = start; i >= 0; i--) {
      if (visited[i] || checkedOnThisPath.contains(nums[i])) {
        continue;
      }

      if (curSum + nums[i] > target) {
        return false;
      }

      curPath.add(nums[i]);
      visited[i] = true;
      checkedOnThisPath.add(nums[i]);

      if (curSum + nums[i] == target) {
        if (makesquare(nums, target, visited, 0, new ArrayList<>(), sides + 1, i - 1)) {
          return true;
        }
      } else {
        if (makesquare(nums, target, visited, curSum + nums[i], curPath, sides, nums.length - 1)) {
          return true;
        }
      }
      visited[i] = false;
      curPath.remove(curPath.size() - 1);
    }

    return false;
  }
}
