package interviews.airbnb._216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
public class Solution {
  private static final int N = 9;

  public List<List<Integer>> combinationSum3(int k, final int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, new ArrayList<>(), k, sum, 1);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final List<Integer> curPath, final int k, final int sum, final int start) {
    if (curPath.size() > k) return;
    if (sum < 0) {
      return;
    }
    if (sum == 0) {
      if (curPath.size() == k) {
        result.add(new ArrayList<>(curPath));
        return;
      }
      return;
    }
    if (start > N) {
      return;
    }
    dfs(result, curPath, k, sum, start + 1);
    curPath.add(start);
    dfs(result, curPath, k, sum - start, start + 1);
    curPath.remove(curPath.size() - 1);
  }
}
