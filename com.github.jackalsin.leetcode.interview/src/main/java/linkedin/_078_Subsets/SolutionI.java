package linkedin._078_Subsets;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> subsets(int[] nums) {

    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    result.add(new ArrayList<>());

    for (int num : nums) {
      final List<List<Integer>> copy = new ArrayList<>();
      for (final List<Integer> l : result) {
        copy.add(new ArrayList<>(l));
      }
      for (List<Integer> c : copy) {
        c.add(num);
      }
      result.addAll(copy);
    }

    return result;
  }
}
