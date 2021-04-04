package lime._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums == null || nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    final boolean[] used = new boolean[nums.length];
    permuteUnique(nums, used, new ArrayList<>());
    return result;
  }

  private void permuteUnique(final int[] nums, final boolean[] used,
                             final List<Integer> curPath) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (used[i] || i > 0 && nums[i - 1] == nums[i] && used[i - 1]) continue;
      used[i] = true;
      curPath.add(nums[i]);
      permuteUnique(nums, used, curPath);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
