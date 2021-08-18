package airbnb._039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public final class SolutionII implements Solution {
  @Override
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private static void combinationSum(final List<List<Integer>> result,
                                     final int[] candidates, final int target,
                                     final List<Integer> curPath, final int start) {
    if (target < 0) return;
    if (target == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    if (start == candidates.length) {
      return;
    }

    for (int i = start; i < candidates.length; ++i) {
      curPath.add(candidates[i]);
      combinationSum(result, candidates, target - candidates[i], curPath, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
