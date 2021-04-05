package _0051_0100._077_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionII implements Solution {

  public List<List<Integer>> combine(int n, int k) {
    final List<List<Integer>> result = new ArrayList<>();
    combine(result, new ArrayList<>(), n, 1, k);
    return result;
  }

  private void combine(final List<List<Integer>> result,
                       final List<Integer> curPath, final int n,
                       final int start, final int k) {
    assert curPath.size() <= k;
    if (curPath.size() == k) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i <= n; ++i) {
      curPath.add(i);
      combine(result, curPath, n, i + 1, k);
      curPath.remove(curPath.size() - 1);
    }
  }
}
