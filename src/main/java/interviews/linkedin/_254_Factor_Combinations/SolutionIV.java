package interviews.linkedin._254_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/10/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), n, 2);
    return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int start) {
    for (int i = start; i * i <= n; i++) {
      if (n % i == 0) {
        temp.add(i);
        temp.add(n / i);
        res.add(new ArrayList<>(temp));
        temp.remove(temp.size() - 1);
        backtrack(res, temp, n / i, i);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
