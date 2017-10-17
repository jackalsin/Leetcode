package interviews.linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 25 / 25 test cases passed. Status: Accepted Runtime: 18 ms
 *
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class SetCandidateSolution implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final Set<Integer> candidates = new HashSet<>();
//    Arrays.stream(nums).forEach(value -> candidates.add(value));
    for (int i : nums) {
      candidates.add(i);
    }
    final List<List<Integer>> result = new ArrayList<>();
    permute(result, candidates, new ArrayList<>());
    return result;
  }

  private void permute(List<List<Integer>> result, Set<Integer> candidates,
                       List<Integer> curPath) {
    if (candidates.size() == 0) {
      result.add(new ArrayList<>(curPath));
    }
    Set<Integer> newCandidates = new HashSet<>(candidates);
    for (int cand : candidates) {
      newCandidates.remove(cand);
      curPath.add(cand);
      permute(result, newCandidates, curPath);
      curPath.remove(curPath.size() - 1);
      newCandidates.add(cand);
    }
  }
}
