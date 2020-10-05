package linkedin._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> permuteUnique(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    permuteUnique(result, nums, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private static void permuteUnique(final List<List<Integer>> result,
                                    final int[] nums, final List<Integer> curPath, final boolean[] visited) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
      visited[i] = true;
      curPath.add(nums[i]);
      permuteUnique(result, nums, curPath, visited);
      curPath.remove(curPath.size() - 1);
      visited[i] = false;
    }
  }
}
