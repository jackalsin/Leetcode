package newsbreak._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/30/2020
 */
public final class DfsSolution implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    final int n = nums.length;
    dfs(result, new ArrayList<>(), nums, new boolean[n]);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final List<Integer> curPath,
                          final int[] nums, final boolean[] used) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (!used[i]) {
        used[i] = true;
        curPath.add(nums[i]);
        dfs(result, curPath, nums, used);
        curPath.remove(curPath.size() - 1);
        used[i] = false;
      }
    }
  }
}
