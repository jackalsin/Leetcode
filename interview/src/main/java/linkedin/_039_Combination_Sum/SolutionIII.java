package linkedin._039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum(result, candidates, target, new ArrayList<>(), 0);
    return result;
  }

  private static void combinationSum(final List<List<Integer>> result,
                                     final int[] nums, final int target,
                                     final List<Integer> curPath, final int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < nums.length; ++i) {
      if (target < nums[i]) return;
      curPath.add(nums[i]);
      combinationSum(result, nums, target - nums[i], curPath, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
