package interviews.linkedin._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public List<List<Integer>> getFactors(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    getFactors(result, new ArrayList<>(), n, 2);
    return result;
  }

  private void getFactors(List<List<Integer>> result, List<Integer> path, int n, int start) {
    if (n != 1) {
      path.add(n);
      if (path.size() > 1) {
        result.add(new ArrayList<>(path));
      }
      path.remove(path.size() - 1);
    }
    for (int i = start; i * i <= n; i++) {
      if (n % i == 0) {
        path.add(i);
        getFactors(result, path, n / i, i);
        path.remove(path.size() - 1);
      }
    }
  }

}
