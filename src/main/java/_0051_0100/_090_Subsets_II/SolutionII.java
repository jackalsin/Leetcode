package _0051_0100._090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/29/2017.
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    dfs(result, new ArrayList<>(), nums, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final List<Integer> curPath, final int[] nums, int start) {
    result.add(new ArrayList<>(curPath));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      curPath.add(nums[i]);
      dfs(result, curPath, nums, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
