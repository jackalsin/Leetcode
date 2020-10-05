package facebook._090_Subsets_II;

import java.util.*;

public class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);

    Set<List<Integer>> result = new HashSet<>();
    result.add(new ArrayList<>());
    for (int num : nums) {
      final Set<List<Integer>> nextResult = new HashSet<>(result);
      for (List<Integer> child : result) {
        final List<Integer> newChild = new ArrayList<>(child);
        child.add(num);
        nextResult.add(newChild);
      }
      result = nextResult;
    }
    return new ArrayList<>(result);
  }
}
