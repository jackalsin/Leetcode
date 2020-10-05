package linkedin._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/21/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    combinationSum2(result, target, candidates, new ArrayList<>(), 0);
    return result;
  }

  private static void combinationSum2(final List<List<Integer>> result,
                                      final int remain, final int[] candidates,
                                      final List<Integer> curPath, final int start) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < candidates.length; ++i) {
      if (i > start && candidates[i] == candidates[i - 1] || candidates[i] > remain) continue;
      curPath.add(candidates[i]);
      combinationSum2(result, remain - candidates[i], candidates, curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
