package uber._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * Time Complexity : O(N)
   * O(n^(1/2) x n^(1/4) x ... x 1) 约等于 O（N）
   *
   * @param n
   * @return
   */
  public List<List<Integer>> getFactors(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, n, new ArrayList<>(), 1);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final int n,
                          final List<Integer> curPath, final int start) {
    if (start > 1) {
      final List<Integer> newPath = new ArrayList<>(curPath);
      newPath.add(n);
      result.add(newPath);
    }
    for (int i = Math.max(2, start); i * i <= n; i++) {
      if (n % i == 0) {
        curPath.add(i);
        dfs(result, n / i, curPath, i);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
