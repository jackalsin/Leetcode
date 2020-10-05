package linkedin._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/1/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    combinationSum2(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private void combinationSum2(final List<List<Integer>> result, final int[] candidates, final int target,
                               final List<Integer> curPath, final int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (target < candidates[i]) return;
      if (i > start && candidates[i] == candidates[i - 1]) continue;
      curPath.add(candidates[i]);
      combinationSum2(result, candidates, target - candidates[i], curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
