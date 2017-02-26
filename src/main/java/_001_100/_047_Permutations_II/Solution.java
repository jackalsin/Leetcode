package _001_100._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 2/26/17.
 */
public class Solution {
  /**
   * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
   * @param nums
   * @return
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(nums); // n log n
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> candidates = new ArrayList<>();
    for (int i : nums) {
      candidates.add(i);
    }
    permuteUniqueHelper(result, candidates, 0);

    return result;
  }

  private static void permuteUniqueHelper(List<List<Integer>> result, List<Integer> candidates,
                                          int candidateIndex) {
    if (candidateIndex == candidates.size() - 1) {
      result.add(new ArrayList<>(candidates));
    } else {
      for (int i = candidateIndex; i < candidates.size(); i++) {
        if (i != candidateIndex && candidates.get(candidateIndex).equals(candidates.get(i)))
          continue;
        swap(candidates, i, candidateIndex);
        permuteUniqueHelper(result, candidates, candidateIndex + 1);
      }

    }
  }

  private static void swap(List<Integer> nums, int i, int j) {
    int tmp = nums.get(i);
    nums.set(i, nums.get(j));
    nums.set(j, tmp);
  }
}
