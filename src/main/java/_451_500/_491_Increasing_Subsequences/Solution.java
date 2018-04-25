package _451_500._491_Increasing_Subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  // TODO: Add explanation
  public List<List<Integer>> findSubsequences(int[] nums) {
    final Set<List<Integer>> result = new HashSet<>();
    findSubsequences(result, new ArrayList<>(), nums, 0);
    return new ArrayList<>(result);
  }

  private void findSubsequences(final Set<List<Integer>> result, final List<Integer> curPath, final int[] nums, int start) {
    if (curPath.size() >= 2) {
      result.add(new ArrayList<>(curPath));
    }
    final Set<Integer> visited = new HashSet<>();
    for (int i = start; i < nums.length; i++) {
      if (visited.contains(nums[i])) {
        continue;
      }

      if (curPath.isEmpty() || curPath.get(curPath.size() - 1) <= nums[i]) {
        curPath.add(nums[i]);
        visited.add(nums[i]);
        findSubsequences(result, curPath, nums, i + 1);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
