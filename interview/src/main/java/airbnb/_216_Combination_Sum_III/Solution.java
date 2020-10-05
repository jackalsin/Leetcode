package airbnb._216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
public final class Solution {
  private static final int N = 9;

  public List<List<Integer>> combinationSum3(int k, final int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, sum, k, 1, new ArrayList<>());
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int sum, final int k,
                          final int start, final List<Integer> curPath) {
    if (sum < 0) {
      return;
    }
    if (k < 0) {
      return;
    }
    if (sum == 0) {
      if (k == 0) {
        result.add(new ArrayList<>(curPath));
      }
      return;
    }
    for (int i = start; i <= N; i++) {
      curPath.add(i);
      dfs(result, sum - i, k - 1, i + 1, curPath);
      curPath.remove(curPath.size() - 1);
    }
  }
}
