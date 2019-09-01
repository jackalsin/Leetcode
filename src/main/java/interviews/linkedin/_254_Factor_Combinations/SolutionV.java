package interviews.linkedin._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/1/2019
 */
public final class SolutionV implements Solution {

  public List<List<Integer>> getFactors(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    backTracking(result, n, new ArrayList<>(), 2);
    return result;
  }

  private static void backTracking(final List<List<Integer>> result, final int n,
                                   final List<Integer> curPath, final int start) {
    for (int i = start; (long) i * i <= n; i++) {
      if (n % i == 0) {
        curPath.add(i);
        curPath.add(n / i);
        result.add(new ArrayList<>(curPath));
        curPath.remove(curPath.size() - 1);
        backTracking(result, n / i, curPath, i);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
