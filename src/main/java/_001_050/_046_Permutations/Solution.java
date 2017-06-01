package _001_050._046_Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/25/2017.
 */
public class Solution {

  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    Set<Integer> candidates = new HashSet<>();
    for (int num : nums) {
      candidates.add(num);
    }
    List<List<Integer>> result = new ArrayList<>();
    permuteHelper(result, new ArrayList<>(), candidates);
    return result;
  }

  private static void permuteHelper(List<List<Integer>> result, List<Integer> curPath,
                                    Set<Integer> candidates) {
    if (candidates.isEmpty()) {
      result.add(new ArrayList<>(curPath));
    } else {
      for (int candidate : candidates) {
        List<Integer> curPathCopy = new ArrayList<>(curPath); //
        curPathCopy.add(candidate);
        Set<Integer> candidatesCopy = new HashSet<>(candidates);
        candidatesCopy.remove(candidate);
        permuteHelper(result, curPathCopy, candidatesCopy);
      }
    }
  }
}
