package interviews.linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 25 / 25 test cases passed. Status: Accepted Runtime: 5 ms
 *
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class BooleanVisitedSolution implements Solution {

  @Override
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  private void permute(List<List<Integer>> result, List<Integer> curPath,
                       final int[] nums, final boolean[] visited) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
    }
    for (int i = 0; i < nums.length; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        curPath.add(nums[i]);
        permute(result, curPath, nums, visited);
        curPath.remove(curPath.size() - 1);
        visited[i] = false;
      }
    }
  }
}
