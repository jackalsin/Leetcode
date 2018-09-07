package interviews.linkedin._040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/7/18
 */
public class Solution {

  /**
   * All candidates are positive;
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum2(result, candidates, new boolean[candidates.length], target, new ArrayList<>(), 0, 0);
    return result;
  }

  private static void combinationSum2(final List<List<Integer>> result, final int[] candidates, final boolean[] used, final int target,
                                      final List<Integer> curPath, final int start, final int curSum) {
    if (curSum == target) {
      result.add(new ArrayList<>(curPath));
      return;
    } else if (curSum > target) {
      return;
    }

    for (int i = start; i < candidates.length; ++i) {
      if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
      used[i] = true;
      curPath.add(candidates[i]);
      combinationSum2(result, candidates, used, target, curPath, i + 1, curSum + candidates[i]);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
