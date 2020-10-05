package linkedin._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    permuteUnique(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  private void permuteUnique(List<List<Integer>> result, List<Integer> curPath, int[] nums,
                             final boolean[] visited) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i - 1]) {
        continue;
      }
      visited[i] = true;
      curPath.add(nums[i]);
      permuteUnique(result, curPath, nums, visited);
      curPath.remove(curPath.size() - 1);
      visited[i] = false;
    }
  }
}
