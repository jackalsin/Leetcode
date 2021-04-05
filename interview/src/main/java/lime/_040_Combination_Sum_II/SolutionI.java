package lime._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum2(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private void combinationSum2(final List<List<Integer>> result, final int[] candidates, final int target,
                               final List<Integer> curPath, final int start) {
    if (target == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    if (start >= candidates.length || target < 0) {
      return;
    }
    for (int i = start; i < candidates.length; ++i) {
      if (i > start && candidates[i - 1] == candidates[i]) {
        continue;
      }
      curPath.add(candidates[i]);
      combinationSum2(result, candidates, target - candidates[i], curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
