package lime._077_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    combine(new ArrayList<>(), n, 1, k);
    return result;
  }

  private void combine(final List<Integer> curPath, final int n,
                       final int start, final int k) {
    System.out.println("curPath = " + curPath + ", n = " + n
        + ", start = " + start + ", k = " + k);
    assert curPath.size() <= k;
    if (curPath.size() == k) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i <= n; ++i) {
      curPath.add(i);
      combine(curPath, n, i + 1, k);
      curPath.remove(curPath.size() - 1);
    }
  }
}
