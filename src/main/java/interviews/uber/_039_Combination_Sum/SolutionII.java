package interviews.uber._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, target, candidates, new ArrayList<>(), 0, 0);
    return result;
  }


  private static void dfs(final List<List<Integer>> result, final int target, final int[] candidates,
                          final List<Integer> curPath, final int sum, final int start) {

    if (target < sum) {
      return;
    } else if (target == sum) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      final int cur = candidates[i];
      curPath.add(cur);
      dfs(result, target, candidates, curPath, sum + cur, i);
      curPath.remove(curPath.size() - 1);
    }

  }
}
