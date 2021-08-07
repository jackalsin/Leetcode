package linkedin._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionV implements Solution {
  @Override
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum2(result, candidates, target, new ArrayList<>(), 0, 0);
    return result;
  }

  private static void combinationSum2(final List<List<Integer>> result, final int[] candidates,
                                      final int target, final List<Integer> curPath,
                                      final int sum, final int start) {
    if (sum > target) return;
    if (sum == target) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < candidates.length; ++i) {
      if (i > start && candidates[i - 1] == candidates[i]) continue;
      curPath.add(candidates[i]);
      combinationSum2(result, candidates, target, curPath, sum + candidates[i], i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }

}
