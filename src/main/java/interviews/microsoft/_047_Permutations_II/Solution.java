package interviews.microsoft._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) { // TODO: Add Documents with combination
    final List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    permuteUnique(result, nums, new boolean[nums.length], new ArrayList<>());
    return result;
  }

  private static void permuteUnique(final List<List<Integer>> result, final int[] nums, boolean[] visited,
                                    final List<Integer> curPath) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;
      /* if the same value, you can only use iff the previous one is used */
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
      curPath.add(nums[i]);
      visited[i] = true;
      permuteUnique(result, nums, visited, curPath);
      visited[i] = false;
      curPath.remove(curPath.size() - 1);
    }

  }
}

