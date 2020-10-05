package linkedin._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> getFactors(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    getFactors(result, n, 1, new ArrayList<>());
    return result;
  }

  private static void getFactors(final List<List<Integer>> result, final int remain, int start, final List<Integer>
      curPath) {
    if (start != 1) {
      curPath.add(remain);
      result.add(new ArrayList<>(curPath));
      curPath.remove(curPath.size() - 1);
    }

    for (int i = Math.max(2, start); i * i <= remain; i++) {
      if (remain % i == 0) {
        curPath.add(i);
        getFactors(result, remain / i, i, curPath);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
