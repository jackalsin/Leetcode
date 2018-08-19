package _051_100._090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // N log N
    dfs(result, new ArrayList<>(), nums, 0);
    return result;
  }

  private void dfs(final List<List<Integer>> result, final List<Integer> curPath, final int[] nums, final int start) {
    result.add(new ArrayList<>(curPath));

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      curPath.add(nums[i]);
      dfs(result, curPath, nums, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
