package newsbreak._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/30/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> permuteUnique(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null) return result;
    Arrays.sort(nums);
    dfs(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final List<Integer> curPath,
                          final int[] nums, final boolean[] visited) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
        continue;
      }
      visited[i] = true;
      curPath.add(nums[i]);
      dfs(result, curPath, nums, visited);
      curPath.remove(curPath.size() - 1);
      visited[i] = false;
    }

  }
}
