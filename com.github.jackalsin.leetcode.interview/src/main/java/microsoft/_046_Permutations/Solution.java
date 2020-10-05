package microsoft._046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    permute(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  private static void permute(final List<List<Integer>> result, final List<Integer> curPath,
                              final int[] nums, final boolean[] visited) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        curPath.add(nums[i]);
        visited[i] = true;
        permute(result, curPath, nums, visited);
        visited[i] = false;
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
