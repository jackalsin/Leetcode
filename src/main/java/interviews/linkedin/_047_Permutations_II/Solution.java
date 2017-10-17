package interviews.linkedin._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class Solution {
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
    }
    for (int i = 0; i < visited.length; ++i) {
      if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
        continue;
      }
      curPath.add(nums[i]);
      visited[i] = true;
      permuteUnique(result, curPath, nums, visited);
      visited[i] = false;
      curPath.remove(curPath.size() - 1);
    }

  }
}
