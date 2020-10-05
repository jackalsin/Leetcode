package microsoft._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolutionII implements Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    dfs(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  private void dfs(final List<List<Integer>> result, final List<Integer> curPath, final int[] nums, final boolean[] used) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
      curPath.add(nums[i]);
      used[i] = true;
      dfs(result, curPath, nums, used);
      used[i] = false;
      curPath.remove(curPath.size() - 1);
    }
  }
}

