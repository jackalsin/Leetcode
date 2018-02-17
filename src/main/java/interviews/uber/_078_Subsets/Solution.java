package interviews.uber._078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/17/2018.
 */
public class Solution {
  /**
   * Todo: check another solution
   */
  public List<List<Integer>> subsets(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    if (nums == null || nums.length == 0) {
      return result;
    }
    for (int i = 0; i < nums.length; i++) {
      final List<List<Integer>> resultCopy = getCopy(result);
      for (final List<Integer> child : resultCopy) {
        child.add(nums[i]);
        result.add(child);
      }
    }
    return result;
  }

  private List<List<Integer>> getCopy(List<List<Integer>> source) {
    final List<List<Integer>> result = new ArrayList<>();
    for (List<Integer> child : source) {
      result.add(new ArrayList<>(child));
    }
    return result;
  }
}
