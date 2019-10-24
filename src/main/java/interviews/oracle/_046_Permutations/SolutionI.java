package interviews.oracle._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/23/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    permute(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  private static void permute(final List<List<Integer>> result,
                              final List<Integer> curPath, final int[] nums, final boolean[] visited) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      curPath.add(nums[i]);
      permute(result, curPath, nums, visited);
      curPath.remove(curPath.size() - 1);
      visited[i] = false;
    }
  }
}
