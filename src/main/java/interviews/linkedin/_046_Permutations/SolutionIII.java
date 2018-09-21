package interviews.linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class SolutionIII implements Solution {
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, new ArrayList<>(), new boolean[nums.length], nums);
    return result;
  }

  private void dfs(final List<List<Integer>> result, List<Integer> curPath, boolean[] used, final int[] nums) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
    }

    for (int i = 0; i < nums.length; ++i) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      curPath.add(nums[i]);
      dfs(result, curPath, used, nums);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
