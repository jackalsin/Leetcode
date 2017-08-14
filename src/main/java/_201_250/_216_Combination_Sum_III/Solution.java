package _201_250._216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    combinationSum(result, k, n, new ArrayList<>());
    return result;
  }

  /**
   *
   * @param k remaining number
   * @param n start number
   * @return
   */
  private static void combinationSum(List<List<Integer>> result,
                          int k, int remainingSum, List<Integer> path) {
    if (k == 0) {
      if (remainingSum == 0) {
        result.add(new ArrayList<>(path));
      }
    } else {
      int lastNum = path.size() == 0 ? 0: path.get(path.size() - 1);
      for (int i = lastNum + 1; i <= 10 - k; i++) {
        path.add(i);
        combinationSum(result, k - 1, remainingSum - i, path);
        path.remove(path.size() - 1);
      }
    }
  }
}
