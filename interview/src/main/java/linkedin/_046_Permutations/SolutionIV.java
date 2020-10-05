package linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class SolutionIV implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    final List<Integer> curPath = new ArrayList<>();
    permute(result, nums, curPath, new boolean[nums.length]);
    return result;
  }

  private static void permute(final List<List<Integer>> result, final int[] nums, final List<Integer> curPath, final boolean[] used) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      used[i] = true;
      curPath.add(nums[i]);
      permute(result, nums, curPath, used);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
