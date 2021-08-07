package linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class BooleanVisitedSolutionI implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    final int n = nums.length;
    permute(result, nums, new boolean[n], new ArrayList<>());
    return result;
  }

  private static void permute(final List<List<Integer>> result, final int[] nums,
                              final boolean[] used, final List<Integer> curPath) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (used[i]) continue;
      curPath.add(nums[i]);
      used[i] = true;
      permute(result, nums, used, curPath);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
