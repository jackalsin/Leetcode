package lime._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return result;
    }
    final boolean[] used = new boolean[nums.length];
    permute(nums, used, new ArrayList<>());
    return result;
  }

  private void permute(final int[] nums, final boolean[] used,
                       final List<Integer> curPath) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (used[i]) continue;
      used[i] = true;
      curPath.add(nums[i]);
      permute(nums, used, curPath);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
