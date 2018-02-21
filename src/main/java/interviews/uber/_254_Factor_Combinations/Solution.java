package interviews.uber._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> getFactors(int n) {
    final List<List<Integer>> result = new ArrayList<>();
    getFactors(result, new ArrayList<>(), n, 2);
    return result;
  }

  private void getFactors(List<List<Integer>> result, final List<Integer> curPath, int n, int start) {
    if (n <= 1) {
      if (curPath.size() > 1) {
        result.add(new ArrayList<>(curPath));
      }
      return;
    }
    for (int i = start; i <= n; i++) {
      if (n % i == 0) {
        curPath.add(i);
        getFactors(result, curPath, n / i, i);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
