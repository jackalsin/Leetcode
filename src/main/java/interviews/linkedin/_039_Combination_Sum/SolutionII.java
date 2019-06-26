package interviews.linkedin._039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/25/2019
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    final List<Integer> curPath = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum(result, target, curPath, candidates, 0);
    return result;
  }

  private static void combinationSum(
      final List<List<Integer>> result, final int target,
      final List<Integer> curPath, final int[] candidates, final int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (candidates[i] > target) return;
      curPath.add(candidates[i]);
      combinationSum(result, target - candidates[i], curPath, candidates, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
