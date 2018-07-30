package interviews.facebook._078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /**
   * Time Complexity: O
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int num : nums) {
      // add without num
      final List<List<Integer>> nextResult = new ArrayList<>(result);

      // add with num
      for (List<Integer> pre : result) {
        final List<Integer> newPre = new ArrayList<>(pre);
        newPre.add(num);
        nextResult.add(newPre);
      }
      result = nextResult;
    }
    return result;
  }
}
