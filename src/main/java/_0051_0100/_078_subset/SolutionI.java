package _0051_0100._078_subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
public final class SolutionI implements Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i : nums) {
      subsets(result, i);
    }
    return result;
  }

  private static void subsets(List<List<Integer>> result, int toAdd) {
    List<List<Integer>> resultCopy = new ArrayList<>(result);
    for (List<Integer> child : resultCopy) {
      List<Integer> childCopy = new ArrayList<>(child);
      childCopy.add(toAdd);
      result.add(childCopy);
    }
    result = resultCopy;
  }
}
