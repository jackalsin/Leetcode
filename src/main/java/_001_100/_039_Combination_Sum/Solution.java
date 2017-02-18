package _001_100._039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/18/2017.
 */
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
      return new ArrayList<>();
    }
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    helper(candidates, target, new ArrayList<>(), 0, result, 0);
    return result;
  }

  private static void helper(int[] candidates, int target, List<Integer> curPath, int curSum,
                             List<List<Integer>> result, int startIndex) {
    if (startIndex == candidates.length) {
      return;
    } else {
      for (int i = startIndex; i < candidates.length; i++) {
        curPath.add(candidates[i]);
        if (curSum + candidates[i] == target) {
          result.add(new ArrayList<>(curPath));
        } else if (curSum < target) {
          helper(candidates, target, new ArrayList<>(curPath), curSum + candidates[i], result, i);
        } else {
          break;
        }
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
