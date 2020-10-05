package uber._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public final class SolutionI implements Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    combinationSum(result, new ArrayList<>(), target, candidates, 0, 0);
    return result;
  }

  private void combinationSum(final List<List<Integer>> result, final List<Integer> curPath,
                              final int target, final int[] candidates, int sum, int startIndex) {
    if (sum > target) {
      return;
    } else if (sum == target) {
      result.add(new ArrayList<>(curPath));
      // don't return, for 0 duplication
      return;
    }
    for (int i = startIndex; i < candidates.length; i++) {
      int candidate = candidates[i];
      curPath.add(candidate);
      combinationSum(result, curPath, target, candidates, sum + candidate, i);
      curPath.remove(curPath.size() - 1);
    }

  }
}
