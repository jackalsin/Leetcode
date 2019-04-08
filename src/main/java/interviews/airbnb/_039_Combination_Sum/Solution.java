package interviews.airbnb._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, target, candidates, new ArrayList<>(), 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int target, final int[] candidates,
                          final List<Integer> curPath, final int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      curPath.add(candidates[i]);
      dfs(result, target - candidates[i], candidates, curPath, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
