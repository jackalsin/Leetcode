package interviews.linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    permute(result, nums, new boolean[nums.length], new ArrayList<>());
    return result;
  }

  private static void permute(final List<List<Integer>> result,
                              final int[] nums, final boolean[] visited,
                              final List<Integer> curPath) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (visited[i]) continue;
      visited[i] = true;
      curPath.add(nums[i]);
      permute(result, nums, visited, curPath);
      curPath.remove(curPath.size() - 1);
      visited[i] = false;
    }
  }
}
