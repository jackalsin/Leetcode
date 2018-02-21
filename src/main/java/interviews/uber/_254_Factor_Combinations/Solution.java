package interviews.uber._254_Factor_Combinations;

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
    getFactors(result, new ArrayList<>(), n, 1);
    return result;
  }

  private void getFactors(List<List<Integer>> result, final List<Integer> curPath, int n, int start) {
    if (start > 1) {
      final List<Integer> toAdd = new ArrayList<>(curPath);
      toAdd.add(n);
      result.add(toAdd);
    }

    for (int i = Math.max(start, 2); i * i <= n; i++) {
      if (n % i == 0) {
        curPath.add(i);
        getFactors(result, curPath, n / i, i);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
