package interviews.linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class SolutionII implements Solution {

  @Override
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    final List<List<Integer>> result = new ArrayList<>();
    permutate(result, nums, new boolean[nums.length], new ArrayList<>());
    return result;
  }

  /**
   * Time Complexity: O(N * N!)
   *
   * @param result
   * @param nums
   * @param visited
   * @param curPath
   */
  private static void permutate(final List<List<Integer>> result,
                                final int[] nums, final boolean[] visited, final List<Integer> curPath) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath)); // O(N)
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;

      curPath.add(nums[i]);
      visited[i] = true;
      permutate(result, nums, visited, curPath);
      visited[i] = false;
      curPath.remove(curPath.size() - 1);
    }
  }
}
