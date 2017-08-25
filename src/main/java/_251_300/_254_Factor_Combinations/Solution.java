package _251_300._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
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
    for (int i = start; i * i <= n; ++i) {
      if (n % i == 0) {
        path.add(i);
        getFactors(result, path, n / i, i);
        path.remove(path.size() - 1);
      }
    }
  }
}
