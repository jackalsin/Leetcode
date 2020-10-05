package airbnb._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public final class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int[] candidates, final int remain,
                          final List<Integer> curPath, final int startIndex) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    if (startIndex == candidates.length) {
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      curPath.add(candidates[i]);
      dfs(result, candidates, remain - candidates[i], curPath, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
