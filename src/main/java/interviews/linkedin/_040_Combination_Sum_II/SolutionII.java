package interviews.linkedin._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/7/18
 */
public final class SolutionII implements Solution {

  /**
   * All candidates are positive;
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    final List<Integer> curPath = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(result, target, curPath, candidates, new boolean[candidates.length], 0, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int target, final List<Integer> curPath,
                          final int[] candidates, final boolean[] used, final int sum, final int start) {
    if (sum > target) {
      return;
    } else if (sum == target) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < candidates.length; ++i) {
      if (i > start && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
      used[i] = true;
      curPath.add(candidates[i]);
      dfs(result, target, curPath, candidates, used, sum + candidates[i], i + 1);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
