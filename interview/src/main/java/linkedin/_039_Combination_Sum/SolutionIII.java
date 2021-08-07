package linkedin._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    combinationSum(candidates, target, result, new ArrayList<>(), 0, 0);
    return result;
  }

  private static void combinationSum(final int[] candidates, final int target,
                                     final List<List<Integer>> result, final List<Integer> curPath,
                                     final int sum, final int start) {
    if (sum > target) return;
    if (sum == target) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < candidates.length; ++i) {
      curPath.add(candidates[i]);
      combinationSum(candidates, target, result, curPath,
          sum + candidates[i], i);
      curPath.remove(curPath.size() - 1);
    }
  }
}