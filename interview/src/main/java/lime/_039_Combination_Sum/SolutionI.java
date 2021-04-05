package lime._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    combinationSum(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private void combinationSum(final List<List<Integer>> result, final int[] candidates, final int sum,
                              final List<Integer> curPath, final int start) {
    if (sum < 0) {
      return;
    }
    if (sum == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start, len = candidates.length; i < len; i++) {
      int c = candidates[i];
      curPath.add(c);
      combinationSum(result, candidates, sum - c, curPath, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
