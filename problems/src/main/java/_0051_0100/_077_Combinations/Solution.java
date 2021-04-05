package _0051_0100._077_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/12/2017.
 */
public class Solution {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    combine(result, 1, n, k, new ArrayList<>());
    return result;
  }

  private void combine(List<List<Integer>> result,
                       int start, final int end, int k, List<Integer> curPath) {
    if (k == 0) {
      result.add(new ArrayList<>(curPath));
    } else {
      for (int i = start; i <= end; i++) {
        curPath.add(i);
        combine(result, i + 1, end, k - 1, curPath);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
