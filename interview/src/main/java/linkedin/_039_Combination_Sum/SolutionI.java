package linkedin._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    final List<Integer> curPath = new ArrayList<>();
    dfs(result, candidates, target, curPath, 0, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int[] candidates, final int target,
                          final List<Integer> curPath, final int start, final int sum) {
    if (sum > target) {
      return;
    } else if (sum == target) {

      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = start; i < candidates.length; ++i) {
      curPath.add(candidates[i]);
      dfs(result, candidates, target, curPath, i, sum + candidates[i]);
      curPath.remove(curPath.size() - 1);
    }
  }
}
