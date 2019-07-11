package interviews.linkedin._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/9/2019
 */
public final class SolutionIII implements Solution {

  public List<List<Integer>> getFactors(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    getFactors(result, n, 1, new ArrayList<>());
    return result;
  }

  public void getFactors(final List<List<Integer>> result, final int n, final int start,
                         final List<Integer> curPath) {
    if (start != 1) {
      curPath.add(n);
      result.add(new ArrayList<>(curPath));
      curPath.remove(curPath.size() - 1);
    }
    for (int i = Math.max(2, start); (long) i * i <= n; i++) {
      if (n % i == 0) {
        curPath.add(i);
        getFactors(result, n / i, i, curPath);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
