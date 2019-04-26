package interviews.airbnb._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
public final class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    dfs(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int[] candidates, final int remain,
                          final List<Integer> curPath, int startIndex) {
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
      if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
      if (candidates[i] > remain) return;
      curPath.add(candidates[i]);
      dfs(result, candidates, remain - candidates[i], curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
